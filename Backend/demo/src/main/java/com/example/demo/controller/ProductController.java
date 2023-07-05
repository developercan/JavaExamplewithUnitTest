package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;

@RestController
@CrossOrigin(origins = "http://localhost:3000") //cors policy for react.js port 3000
public class ProductController {
    private List<Product> Products;

    public ProductController() {
        Products = new ArrayList<>();
        Products.add(new Product("Telephone", 450.00));
        Products.add(new Product("Computer", 950.00));
        Products.add(new Product("Desk", 150.00));
        Products.add(new Product("Aquarium", 100.00));
        Products.add(new Product("Keyboard", 50.00));
        Products.add(new Product("Mouse", 25.00));
        Products.add(new Product("Modem", 75.00));
    }

    @GetMapping("/Products")
    public List<Product> getAll(){
        return Products;
    }
}
