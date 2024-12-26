package com.example.scalerbackendmodule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.scalerbackendmodule.models.Products;
import com.example.scalerbackendmodule.repository.projection.ProductProjection;

public interface ProductRepository extends JpaRepository<Products, Long> {

    @SuppressWarnings("unchecked")
    Products save(Products products);

    Products findByTitle(String title);

    Products findByDescription(String description);

    // Implement HQL
    @Query("select p from Product p where p.category.id =:categoryId")
    List<Products> getProductByCategoryId(@Param("categoryId") Long categoryId);

    // Implement NativeQuery
    @Query(value = "select * from product p where p.category_id =:categoryId", nativeQuery = true)
    List<Products> getProductByCategoryIdNativeQueries(@Param("categoryId") Long categoryId);

    @Query("select p.title as title, p.id as id from Product p where p.category.id =:categoryId")
    List<ProductProjection> getProductByCategoryIdUsingProjections(@Param("categoryId") Long categoryId);
}
