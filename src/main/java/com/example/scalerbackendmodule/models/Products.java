package com.example.scalerbackendmodule.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Products {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private Category category;
}
