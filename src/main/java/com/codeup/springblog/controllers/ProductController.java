package com.codeup.springblog.controllers;

import com.codeup.springblog.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    private final ProductRepository productsDao;

    public ProductController(ProductRepository productsDao) {
        this.productsDao = productsDao;
    }

    @GetMapping("/products")
    public String index(Model model) {
        model.addAttribute("products", productsDao.findAll());
        return "products/index";
    }

}
