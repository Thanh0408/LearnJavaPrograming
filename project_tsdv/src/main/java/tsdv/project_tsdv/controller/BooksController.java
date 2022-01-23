package tsdv.project_tsdv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tsdv.project_tsdv.entity.Authors;
import tsdv.project_tsdv.entity.Books;
import tsdv.project_tsdv.entity.Categories;
import tsdv.project_tsdv.entity.Publishers;
import tsdv.project_tsdv.repository.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.List;


@Controller
@RequestMapping(value = "/admin_books")
@SessionScope
public class BooksController {
    @Autowired
    BooksRepository booksRepository;
    @Autowired
    CategoriesRepository categoriesRepository;
    @Autowired
    AuthorsRepository authorsRepository;
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    PublishersRepository publishersRepository;

    public static String uploadDirectory = System.getProperty("user.dir")+ "/src/main/resources/static/imagesData";

    @RequestMapping("")
    public String getBooksList(Model model, HttpSession session) {
        if (session.getAttribute("role").equals("1")){
            List<Books> booksList = booksRepository.findAll();
            model.addAttribute("booksList", booksList);
            return "admin/booksList";
        }else {
            return "fail/PermissionDenied";
        }
    }

    @RequestMapping("/{id}")
    public String getBookById (Model model,
                               HttpSession session,
                               @PathVariable(value= "id") Long id){
        if (session.getAttribute("role").equals("1")){
            Books book = booksRepository.getById(id);
            List<Authors> authorsList = authorsRepository.findAll();
            List<Categories> categoriesList = categoriesRepository.findAll();
            List<Publishers> publishersList = publishersRepository.findAll();
            model.addAttribute("book", book);
            model.addAttribute("authorsList", authorsList);
            model.addAttribute("categoriesList", categoriesList);
            model.addAttribute("publishersList", publishersList);
            return "admin/booksDetail";
        }else {
            return "fail/PermissionDenied";
        }
    }

    @RequestMapping("/edit/{id}")
    public String editBooks(
            @PathVariable (value = "id") Long id,
                            HttpSession session,
                            Model model)  {
        if (session.getAttribute("role").equals("1")){
            Books book = booksRepository.getById(id);
            List<Categories> categoriesList = categoriesRepository.findAll();
            List<Authors> authorsList = authorsRepository.findAll();
            List<Publishers> publishersList = publishersRepository.findAll();
            model.addAttribute("book", book);
            model.addAttribute("categoriesList", categoriesList);
            model.addAttribute("authorsList", authorsList);
            model.addAttribute("publishersList", publishersList);
            return "admin/booksEdit";
        }else {
            return "fail/PermissionDenied";
        }
    }

    @RequestMapping("/add")
    public String addBook(Model model,HttpSession session) {
        if (session.getAttribute("role").equals("1")){
            Books book = new Books();
            List<Categories> categoriesList = categoriesRepository.findAll();
            List<Authors> authorsList = authorsRepository.findAll();
            List<Publishers> publishersList = publishersRepository.findAll();
            model.addAttribute("categoriesList", categoriesList);
            model.addAttribute("authorsList", authorsList);
            model.addAttribute("publishersList", publishersList);
            model.addAttribute("book", book);
            return "admin/booksAdd";
        }else {
            return "fail/PermissionDenied";
        }
    }

    @RequestMapping("/save")
    public String saveUpdate (
            Books book, BindingResult result,
            @RequestParam("image") MultipartFile image,
//            RedirectAttributes attributes,
            @RequestParam(value = "id", required = false) Long id)
    {
//        if (result.hasErrors()) {
//            if (id == null) {
//                return "admin/booksAdd";
//            } else {
//                return "admin/booksEdit";
//            }
//        }
        if (image.getOriginalFilename().length() != 0) {
            Instant instant = Instant.now();
            String preName = String.valueOf(instant);
            preName = preName.replace(":","");
            preName = preName.replace("-","");
            preName = preName.replace(".","");
            System.out.println(preName);
            String filename = preName + image.getOriginalFilename().substring(image.getOriginalFilename().length() - 4);
            Path fileNameAndPath = Paths.get(uploadDirectory, filename);
            System.out.println("this is save");
            try {
                Files.write(fileNameAndPath, image.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            book.setImage(filename);
            book.setId(id);
            booksRepository.save(book);
            return "redirect:/admin_books";
        }else{
//            attributes.addFlashAttribute("message", "have no photo");
            book.setId(id);
            booksRepository.save(book);
            return "redirect:/admin_books";
        }
    }

    @RequestMapping("/delete/{id}")
    public String deleteBook(
            @PathVariable(value = "id") Long id) {
        Books books = booksRepository.getById(id);
        booksRepository.delete(books);
        return "redirect:/admin_books";
    }

    @RequestMapping("/price_asc")
    public String sortBookAsc(Model model) {
        List<Books> booksList = booksRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
        model.addAttribute("booksList", booksList);
        return "admin/booksList";
    }
    @RequestMapping("/price_desc")
    public String sortBookDesc(Model model) {
        List<Books> booksList = booksRepository.findAll(Sort.by(Sort.Direction.DESC, "price"));
        model.addAttribute("booksList", booksList);
        return "admin/booksList";
    }
    @RequestMapping("/search")
    public String searchBook(Model model, @RequestParam(value = "name")String name) {
        List<Books> booksList = booksRepository.findByUsernameContaining(name);
        model.addAttribute("booksList",booksList);
        return "admin/booksList";
    }

}
