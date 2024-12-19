package com.example.scalerbackendmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.scalerbackendmodule.models.Products;

@SpringBootApplication
public class ScalerbackendmoduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScalerbackendmoduleApplication.class, args);

		Products ps = new Products();
		ps.setId(12L);
		System.out.println(ps);
	}

}
