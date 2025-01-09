package com.example.scalerbackendmodule.server;

import java.util.List;

import com.example.scalerbackendmodule.exception.ProductNotFoundException;
import com.example.scalerbackendmodule.models.Products;

public interface ProductService {
    Products getSingleProduct(Long id) throws ProductNotFoundException;

    Products updateSingleProduct(Long id, String title, String description, Double price, String category)
            throws ProductNotFoundException;

    List<Products> getAllProducts();

    void deleteProductById(Long id) throws ProductNotFoundException;

    Products createProduct(
            Long id, String title, String description, Double price, String category);

}
