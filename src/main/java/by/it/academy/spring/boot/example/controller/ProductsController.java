package by.it.academy.spring.boot.example.controller;

import by.it.academy.spring.boot.example.model.Manufacturer;
import by.it.academy.spring.boot.example.model.dto.CreateProductDTO;
import by.it.academy.spring.boot.example.service.ManufacturerService;
import by.it.academy.spring.boot.example.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/products")
public class ProductsController {

    private final ProductService productService;
    private final ManufacturerService manufacturerService;

    public ProductsController(ProductService productService, ManufacturerService manufacturerService) {
        this.productService = productService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public String productList(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("manufacturers", manufacturerService.getAll());
        return "products";
    }

    @GetMapping(path = "/manufacturer/{id}")
    public String productsByManufacturer(@PathVariable("id") Long id, Model model) {
        if (id < 1) {
            return "redirect:/products";
        } else {
            model.addAttribute("products", productService.getProductsByManufacturer(id));
        }
        model.addAttribute("manufacturers", manufacturerService.getAll());
        return "products";
    }

    @GetMapping("/create")
    public String createProductPage(Model model) {
        model.addAttribute("product", new CreateProductDTO());
        List<Manufacturer> manufacturers = manufacturerService.getAll();
        model.addAttribute("manufacturers", manufacturers);
        return "createProduct";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute CreateProductDTO productDTO, Model model) {
        productService.createProduct(productDTO);
        return "redirect:/products";
    }

}
