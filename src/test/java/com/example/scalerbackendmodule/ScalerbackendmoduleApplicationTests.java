package com.example.scalerbackendmodule;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.scalerbackendmodule.models.Category;
import com.example.scalerbackendmodule.models.Products;
import com.example.scalerbackendmodule.repository.CategoryRepository;
import com.example.scalerbackendmodule.repository.ProductRepository;

@SpringBootTest
class ScalerbackendmoduleApplicationTests {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testQueries() {
		List<Products> allProducts = productRepository.getProductByCategoryIdNativeQueries(1L);

		for (Products product : allProducts) {
			System.out.println(product);
		}

		// List<ProductProjection> productProjectionList =
		// productRepository.getProductByCategoryIdUsingProjections(1L);
		// System.out.println(productProjectionList.get(0).getTitle());

	}

	@Test
	void FetchTypeTest() {
		Category cat = categoryRepository.findById(1L).get();
		System.out.println(cat.getId());
		System.out.println("We are done here");

		List<Products> currentProduct = cat.getProducts();
		System.out.println(currentProduct.size());

		System.out.println("We got the products as well");

	}
}
