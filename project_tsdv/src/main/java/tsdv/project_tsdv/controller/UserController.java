package tsdv.project_tsdv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;
import tsdv.project_tsdv.entity.Books;
import tsdv.project_tsdv.entity.Categories;
import tsdv.project_tsdv.entity.Publishers;
import tsdv.project_tsdv.repository.BooksRepository;
import tsdv.project_tsdv.repository.CategoriesRepository;
import tsdv.project_tsdv.repository.PublishersRepository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("bookshop")
public class UserController {
    @Autowired
    BooksRepository booksRepository;
    @Autowired
    CategoriesRepository categoriesRepository;
    @Autowired
    PublishersRepository publishersRepository;
    @RequestMapping("")
    public String showHomePage(Model model,
                               HttpSession session) {
        System.out.println("this is bookshop");
        List<Books> booksListOrder = null;
        List<Books> bestPriceList = new ArrayList<>();
        List<Books> bestPriceListTemp = booksRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
        for (int i = 0; i < 4; i++) {
            bestPriceList.add(bestPriceListTemp.get(i));
        }
        List<Categories> categoriesList = categoriesRepository.findAll();
        List<Books> booksList = booksRepository.findAll();
        List<Publishers> publishersList = publishersRepository.findAll();
        session.setAttribute("booksListOrder", booksListOrder);
        model.addAttribute("publishersList", publishersList);
        model.addAttribute("booksList", booksList);
        model.addAttribute("bestPriceList", bestPriceList);
        model.addAttribute("categoriesList", categoriesList);
//        System.out.println(booksList);
        return "/index";
    }
    @RequestMapping("{id}")
    public String findById (Model model,
                            @PathVariable("id")Long id) {
        Books book = booksRepository.getById(id);
        model.addAttribute("book", book);
        return "user/bookDetailU";
    }

    @RequestMapping("/searchByName")
    public String searchByName(Model model, @RequestParam(value = "name")String name) {
        List<Books> booksList = booksRepository.findByUsernameContaining(name);
        model.addAttribute("booksList",booksList);
        model.addAttribute("key", name);
        return "user/searchOption";
    }
    @RequestMapping("/searchByCate/{id}")
    public String searchByCate(Model model,
                               @PathVariable(value = "id")Long id){
        List<Books> booksTemp = booksRepository.findAll();
        List<Books> booksList = new ArrayList<Books>();
        Categories categories = categoriesRepository.getById(id);
        for (int i = 0; i < booksTemp.size(); i++) {
            List<Categories> categoriesList = booksTemp.get(i).getCategoriesList();
            for (int j= 0; j < categoriesList.size(); j++) {
                if (categoriesList.get(j).getName().equals(categories.getName())) {
                    booksList.add(booksTemp.get(i));
                }
            }
        }
        model.addAttribute("booksList",booksList);
        model.addAttribute("key", categories.getName());
        return "user/searchOption";
    }
    @RequestMapping("/buyNow/{id}")
    public String buyNow(Model model,
                         HttpSession session,
                         @PathVariable("id")Long id) {
        Books book = booksRepository.getById(id);
        session.getAttribute("booksListSession");

        model.addAttribute("booksList", book);
        return "cart";
    }
}
