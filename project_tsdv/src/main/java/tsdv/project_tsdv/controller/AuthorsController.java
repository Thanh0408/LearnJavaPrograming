package tsdv.project_tsdv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tsdv.project_tsdv.entity.Authors;
import tsdv.project_tsdv.entity.Books;
import tsdv.project_tsdv.repository.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin_authors")
public class AuthorsController {
    @Autowired
    AuthorsRepository authorsRepository;
    @Autowired
    BooksRepository booksRepository;

    @RequestMapping("")
    public String getAuthorsList(Model model) {
        List<Authors> authorsList = authorsRepository.findAll();
        model.addAttribute("authorsList", authorsList);
        return "admin/authorsList";
    }

    @RequestMapping("/{id}")
    public String getAuthorById (Model model,
                               @PathVariable(value= "id") Long id){
        Authors authors = authorsRepository.getById(id);
        List<Books> booksList = booksRepository.findAll();
        model.addAttribute("booksList", booksList);
        model.addAttribute("authors", authors);
        return "admin/authorsDetail";
    }

    @RequestMapping("/edit/{id}")
    public String editAuthors(
            @PathVariable (value = "id") Long id, Model model) {
        Authors authors = authorsRepository.getById(id);
        System.out.println(authors.getDob());
        model.addAttribute("authors", authors);
        return "admin/authorsEdit";
    }

    @RequestMapping("/add")
    public String addAuthor(Model model) {
        Authors authors = new Authors();
        model.addAttribute("authors", authors);
        return "admin/authorsAdd";
    }

    @RequestMapping("/save")
    public String save(@Valid Authors authors, BindingResult result, Model model,
                       @RequestParam(value = "id", required=false) Long id)
    {
        if (result.hasErrors()) {
            if (id == null) {
                return "admin/authorsAdd";
            } else {
                return "admin/authorsEdit";
            }
        }
        authors.setId(id);
        authorsRepository.save(authors);
        return "redirect:/admin_authors";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable ("id") Long id) {
        Authors authors = authorsRepository.getById(id);
        authorsRepository.delete(authors);
        return "redirect:/admin_authors";
    }
    @RequestMapping("/search")
    public String searchBook(Model model, @RequestParam(value = "name")String name) {
        List<Authors> authorsList = authorsRepository.findByUsernameContaining(name);
        model.addAttribute("authorsList",authorsList);
        return "admin/authorsList";
    }

}
