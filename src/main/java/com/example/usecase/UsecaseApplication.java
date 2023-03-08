package com.example.usecase;

//import org.springframework.boot.SpringApplication;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Collections;

import javax.management.loading.PrivateClassLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.kafka.core.KafkaTemplate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class UsecaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsecaseApplication.class, args);
	}
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors
				.basePackage("com.example.usecase"))
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Shopping App API",
				"An application where user can buy,search items online",
				"1.0", "Free to use",
				new springfox.documentation.service.Contact("Aditi Singh Jadoun", "https://github.com/KazamiSkyress","aditi@gmail.com"),
				"Taani license", "https://github.com/KazamiSkyress", Collections.emptyList());
	}
//	

}
