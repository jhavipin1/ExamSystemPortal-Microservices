package com.quiz;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@OpenAPIDefinition(info = @Info(title = "Quiz Module", version = "1.0", description = "Exam System Module"))
@SpringBootApplication
@EnableFeignClients
public class QuizModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizModuleApplication.class, args);
	}

}
