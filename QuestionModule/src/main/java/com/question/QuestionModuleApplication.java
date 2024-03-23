package com.question;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "Question Module", version = "1.0", description = "Exam System Module"))
@SpringBootApplication
public class QuestionModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionModuleApplication.class, args);
	}

}
