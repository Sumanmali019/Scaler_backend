package com.example.scalerbackendmodule;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.scalerbackendmodule.models.Products;
import com.example.scalerbackendmodule.repository.ProductRepository;
import com.example.scalerbackendmodule.repository.projection.ProductProjection;

@SpringBootTest
class ScalerbackendmoduleApplicationTests {

	@Autowired
	private ProductRepository productRepository;

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
}
