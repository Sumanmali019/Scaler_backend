package com.example.scalerbackendmodule.dto;

import com.example.scalerbackendmodule.models.Category;
import com.example.scalerbackendmodule.models.Products;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;

    // This will get the product of my implmentation using
    // the values from fakestore
    public Products getProduct() {
        Products product = new Products();
        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);
        product.setImageUrl(image);

        Category cat = new Category();
        cat.setTitle(category);
        product.setCategory(cat);

        return product;
    }
}
