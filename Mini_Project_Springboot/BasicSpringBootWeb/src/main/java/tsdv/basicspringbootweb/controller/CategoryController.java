package tsdv.basicspringbootweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tsdv.basicspringbootweb.entity.Category;
import tsdv.basicspringbootweb.repository.CategoryRepository;
import tsdv.basicspringbootweb.repository.ProductRepository;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping("")
    public String showShopList(Model model){
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute(categoryList);
        return "categoryList";
    }
}
