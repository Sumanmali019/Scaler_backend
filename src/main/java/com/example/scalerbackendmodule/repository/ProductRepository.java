package com.example.scalerbackendmodule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.scalerbackendmodule.models.Products;
import com.example.scalerbackendmodule.repository.projection.ProductProjection;

public interface ProductRepository extends JpaRepository<Products, Long> {

    // Save

    // Get

    // Get all

    // delete

    // update

    // This will insert product records in my product table
    @SuppressWarnings("unchecked")
    Products save(Products products);

    // select * from product where title = title;
    Products findByTitle(String title);

    // Create a query like this "Select * from product where description =
    // description;"
    Products findByDescription(String description);

    // Implement HQL
    @Query("select p from Products p where p.category.id =:categoryId")
    List<Products> getProductByCategoryId(@Param("categoryId") Long categoryId);

    // Implement NativeQuery
    @Query(value = "select * from products p where p.category_id =:categoryId", nativeQuery = true)
    List<Products> getProductByCategoryIdNativeQueries(@Param("categoryId") Long categoryId);

    @Query("select p.title as title, p.id as id from Products p where p.category.id =:categoryId")
    List<ProductProjection> getProductByCategoryIdUsingProjections(@Param("categoryId") Long categoryId);
}
