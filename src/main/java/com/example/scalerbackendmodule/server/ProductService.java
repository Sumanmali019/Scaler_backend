package com.example.scalerbackendmodule.server;

import java.util.List;

import com.example.scalerbackendmodule.models.Products;

public interface ProductService {
    Products getSingleProduct(Long id);

    List<Products> getAllProducts();

    Products createProduct(Products producer);

}
