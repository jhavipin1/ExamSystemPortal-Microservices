package com.category;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@OpenAPIDefinition(info = @Info(title = "Category Module", version = "1.0", description = "Exam System Portal"))
@SpringBootApplication
@EnableFeignClients
public class CategoryModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CategoryModuleApplication.class, args);
	}

}
