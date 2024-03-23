package com.identityModule;

import com.identityModule.helpers.RefreshableCRUDRepositoryImpl;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(repositoryBaseClass = RefreshableCRUDRepositoryImpl.class)
@OpenAPIDefinition(info = @Info(title = "Identity Module", version = "1.0", description = "Exam System Portal"))
@SpringBootApplication
public class IdentityModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdentityModuleApplication.class, args);
	}

}
