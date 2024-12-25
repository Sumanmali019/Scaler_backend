package com.example.scalerbackendmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scalerbackendmodule.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByTitle(String title);

}
