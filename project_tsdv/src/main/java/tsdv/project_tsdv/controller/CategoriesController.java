package tsdv.project_tsdv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tsdv.project_tsdv.entity.Categories;
import tsdv.project_tsdv.repository.CategoriesRepository;

import java.util.List;

@Controller
@RequestMapping("/admin_categories")
public class CategoriesController {
    @Autowired
    CategoriesRepository categoriesRepository;
    @RequestMapping("")
    public String showCategoriesList(Model model) {
        List<Categories> categoriesList = categoriesRepository.findAll();
        model.addAttribute("categoriesList", categoriesList);
        return "admin/categoriesList";
    }
    @RequestMapping("/add")
    public String addCategories(Model model) {
        Categories categories = new Categories();
        model.addAttribute("categories", categories);
        return "admin/categoriesAdd";
    }
    @RequestMapping("/edit/{id}")
    public String editCategories(@PathVariable(value = "id") Long id, Model model) {
        Categories categories = categoriesRepository.getById(id);
        model.addAttribute("categories", categories);
        return "admin/categoriesEdit";
    }
    @RequestMapping("/delete/{id}")
    public String categoriesDelete(@PathVariable(value = "id")Long id, Model model) {
        Categories categories = categoriesRepository.getById(id);
        categoriesRepository.delete(categories);
        return "redirect:/admin_categories";
    }
    @RequestMapping("save")
    public String saveCategory(Categories categories, BindingResult result,
                               @RequestParam(value = "id", required = false) Long id){
        if (result.hasErrors()) {
            System.out.println("x");
            if (id == null) {
                return "admin/categoriesAdd";
            } else {
                return "admin/categoriesEdit";
            }
        }
        categories.setId(id);
        categoriesRepository.save(categories);
        return "redirect:/admin_categories";
    }
    @RequestMapping("/{id}")
    public String getAuthorById (Model model,
                                 @PathVariable(value= "id") Long id){
        Categories categories = categoriesRepository.getById(id);
        model.addAttribute("category", categories);
        return "admin/categoriesDetail";
    }
    @RequestMapping("/search")
    public String searchBook(Model model, @RequestParam(value = "name")String name) {
        List<Categories> categoriesList = categoriesRepository.findByUsernameContaining(name);
        model.addAttribute("categoriesList",categoriesList);
        return "admin/categoriesList";
    }
}
