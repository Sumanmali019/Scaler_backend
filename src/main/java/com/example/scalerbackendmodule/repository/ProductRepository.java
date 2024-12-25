package com.example.scalerbackendmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.scalerbackendmodule.models.Products;
import java.util.List;


public interface ProductRepository extends JpaRepository<Products, Long> {





    Products save (Products products);
    Products  findByDescription(String description);
}
