package com.example.scalerbackendmodule.server;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.scalerbackendmodule.models.Products;

@Service
public class FakeStoreProductService implements ProductService {

    public Products getSingleProduct(Long id) {
        System.out.println("We are in single product method______________________>>>>");
        return null;
    }

    public List<Products> getAllProducts() {

        return List.of();
    }

    public Products createProduct(Products producer) {

        return null;
    }
}
