package com.example.scalerbackendmodule.controller;

import com.example.scalerbackendmodule.dto.ErrorDto;
import com.example.scalerbackendmodule.exception.ProductNotFoundException;
import com.example.scalerbackendmodule.models.Products;
import com.example.scalerbackendmodule.server.ProductService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    // CRUD apis around product
    // For the product
    // 1. to create a product
    // 2. get a product
    // 3. update a product
    // 4. delete a product

    private ProductService productService;

    public ProductController(@Qualifier("selfproductservice") ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public Products createProducts(@RequestBody Products product) {
        Products products = productService.createProduct(
                product.getId(),
                product.getTitle(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getTitle()
        // product.getImageUrl());
        );

        return products;

    }

    // This is get the products
    @GetMapping("/products/{id}")
    public ResponseEntity<Products> getProductsbyId(@PathVariable("id") Long id) throws ProductNotFoundException {
        System.out.println("Starting API call to get product by ID...");
        Products product = productService.getSingleProduct(id);
        System.out.println("API call completed successfully.");
        ResponseEntity<Products> responseEntity = new ResponseEntity<>(
                product, HttpStatus.OK);

        return responseEntity;
    }

    // This will help update product
    @PutMapping("/products/{id}")
    public ResponseEntity<Products> updateProducts(@PathVariable("id") Long id, @RequestBody Products product)
            throws ProductNotFoundException {
        Products updatedProduct = productService.updateSingleProduct(
                id,
                product.getTitle(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getTitle());

        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    // This will help delete product
    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable("id") Long id) {
        try {
            productService.deleteProductById(id);
            return new ResponseEntity<>("Product deleted successfully.", HttpStatus.OK);
        } catch (ProductNotFoundException e) {
            return new ResponseEntity<>("Product not found: " + e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> handleProductNotFoundException(Exception e) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(e.getMessage());

        ResponseEntity<ErrorDto> responseEntity = new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);

        return responseEntity;
    }

}
