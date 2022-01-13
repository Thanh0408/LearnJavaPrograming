package tsdv.basicspringbootweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import tsdv.basicspringbootweb.entity.Category;
import tsdv.basicspringbootweb.entity.Product;
import tsdv.basicspringbootweb.entity.ProductDetail;
import tsdv.basicspringbootweb.entity.Shop;
import tsdv.basicspringbootweb.repository.CategoryRepository;
import tsdv.basicspringbootweb.repository.ProductDetailRepository;
import tsdv.basicspringbootweb.repository.ProductRepository;
import tsdv.basicspringbootweb.repository.ShopRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductDetailRepository productDetailRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ShopRepository shopRepository;

    @RequestMapping("")
    public String getProductList(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "productList";
    }

    @RequestMapping("/{id}")
    public String getProductById(Model model,
                                 @PathVariable(value = "id") Long id){
        Product product = productRepository.getById(id);
        ProductDetail productDetail = productDetailRepository.getById(id);
        model.addAttribute("product",product);
        model.addAttribute("productDetail", productDetail);
        return "productDetail";
    }

    @RequestMapping("/add")
    public String AddProduct(Model model){
        Product product = new Product();
        ProductDetail productDetail = new ProductDetail();
        List<Category> categories = categoryRepository.findAll();
        List<Shop> shops = shopRepository.findAll();
        model.addAttribute("product", product);
        model.addAttribute("productDetail", productDetail);
        model.addAttribute("categories", categories);
        model.addAttribute("shops", shops);
        return "productAdd";
    }

    @RequestMapping("/update/{id}")
    public String updateProduct (Model model,
                                 @PathVariable(value= "id") Long id){
        Product product = productRepository.getById(id);
        ProductDetail productDetail = productDetailRepository.getById(id);
        List<Shop> shopList = shopRepository.findAll();
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("product", product);
        model.addAttribute("productDetail", productDetail);
        model.addAttribute("shopList", shopList);
        model.addAttribute("categoryList", categoryList);
        return "productUpdate";
    }
}
