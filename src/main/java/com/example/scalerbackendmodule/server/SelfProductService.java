package com.example.scalerbackendmodule.server;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.scalerbackendmodule.exception.ProductNotFoundException;
import com.example.scalerbackendmodule.models.Category;
import com.example.scalerbackendmodule.models.Products;
import com.example.scalerbackendmodule.repository.CategoryRepository;
import com.example.scalerbackendmodule.repository.ProductRepository;

@Service("selfproductservice")
public class SelfProductService implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Products getSingleProduct(Long id) throws ProductNotFoundException {
        Optional<Products> product = productRepository.findById(id);

        if (product.isPresent()) {
            return product.get();
        }
        throw new ProductNotFoundException("Product not found with id " + id);

    }

    @Override
    public List<Products> getAllProducts() {

        Optional<List<Products>> products = Optional.of(productRepository.findAll());
        if (products.isPresent()) {
            return products.get();
        }
        return List.of();
    }

    @Override
    public Products createProduct(Long id, String title, String description, Double price, String categoryTitle) {

        /*
         * 1. Check if the category exists in the database.
         * 2. If it does not exist, create a new category and save it in the database.
         * 3. If it exists, get the category from the database.
         */

        Products product = new Products();

        Optional<Category> cureentcat = categoryRepository.findByTitle(categoryTitle);
        if (cureentcat.isEmpty()) {
            Category newCat = new Category();
            newCat.setTitle(categoryTitle);
            Category newRow = categoryRepository.save(newCat);
            product.setCategory(newRow);
        } else {
            Category cureentCategory = cureentcat.get();
            product.setCategory(cureentCategory);
        }
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        // product.setImageUrl(imgurl);

        Products saveproducts = productRepository.save(product);
        return saveproducts;
    }

}
