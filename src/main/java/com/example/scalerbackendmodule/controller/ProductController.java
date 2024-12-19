package com.example.scalerbackendmodule.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.scalerbackendmodule.models.Products;
import com.example.scalerbackendmodule.server.ProductService;

@RestController
public class ProductController {

    // CRUD apis around product
    // For the product
    // 1. to create a product
    // 2. get a product
    // 3. update a product
    // 4. delete a product

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public Products createProducts(@RequestBody Products product) {
        return productService.createProduct(
                product.getId(),
                product.getTitle(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getTitle(),
                product.getImageUrl());

    }

    // This is get the products
    @GetMapping("/products/{id}")
    public Products getProducts(@PathVariable("id") Long id) {
        System.out.println("String of API...");
        Products p = productService.getSingleProduct(id);
        System.out.println("Ending of API...");
        return p;
    }

    // This will help update product
    public void updateProducts(Products product) {

    }

    // This will help delete product
    public void deleteProducts(Products product) {

    }
}
