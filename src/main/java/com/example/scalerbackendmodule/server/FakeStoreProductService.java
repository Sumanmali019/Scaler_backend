package com.example.scalerbackendmodule.server;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.scalerbackendmodule.dto.FakeStoreProductDto;
import com.example.scalerbackendmodule.exception.ProductNotFoundException;
import com.example.scalerbackendmodule.models.Products;

@Service
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Products getSingleProduct(Long id) throws ProductNotFoundException {
        System.out.println("Inside FaKestoew product service");
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id,
                FakeStoreProductDto.class);

        if (fakeStoreProductDto == null) {
            throw new ProductNotFoundException("Product not found with id " + id);
        }

        return fakeStoreProductDto.getProduct();
    }

    public List<Products> getAllProducts() {

        return List.of();
    }

    public Products createProduct(Long id, String title, String description, Double price, String category,
            String image) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(id);
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setImage(image);

        FakeStoreProductDto response = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                fakeStoreProductDto,
                FakeStoreProductDto.class);

        return response.getProduct();
    }

}
