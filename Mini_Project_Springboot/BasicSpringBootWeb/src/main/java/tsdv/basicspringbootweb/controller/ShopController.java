package tsdv.basicspringbootweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tsdv.basicspringbootweb.entity.Shop;
import tsdv.basicspringbootweb.repository.ProductRepository;
import tsdv.basicspringbootweb.repository.ShopRepository;

import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    ShopRepository shopRepository;
    @Autowired
    ProductRepository productRepository;
    @RequestMapping("")
    public String shopList(Model model) {
        List<Shop> shopList = shopRepository.findAll();
        model.addAttribute("shopList",shopList);
        return "shopList";
    }
}
