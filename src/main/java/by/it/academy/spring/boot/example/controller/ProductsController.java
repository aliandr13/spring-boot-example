package by.it.academy.spring.boot.example.controller;

import by.it.academy.spring.boot.example.model.Product;
import by.it.academy.spring.boot.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/products")
public class ProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String productList(Model model) {
        List<Product> allProducts = productService.getAllProducts();
        model.addAttribute("products", allProducts);
        return "products";
    }

}
