package com.example.scalerbackendmodule.server;

import java.util.List;

import com.example.scalerbackendmodule.exception.ProductNotFoundException;
import com.example.scalerbackendmodule.models.Products;

public interface ProductService {
    Products getSingleProduct(Long id) throws ProductNotFoundException;

    List<Products> getAllProducts();

    Products createProduct(
            Long id, String title, String description, Double price, String category);

}
