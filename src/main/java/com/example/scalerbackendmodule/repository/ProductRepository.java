package com.example.scalerbackendmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.scalerbackendmodule.models.Products;

public interface ProductRepository extends JpaRepository<Products, Long> {

    @SuppressWarnings("unchecked")
    Products save(Products products);

    Products findByTitle(String title);

    Products findByDescription(String description);
}
