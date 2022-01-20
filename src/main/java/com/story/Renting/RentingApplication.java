package com.story.Renting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

//@Configuration
//@ComponentScan
//@EnableAutoConfiguration
//@EntityScan("com.story.Renting.Entity.Book") // path of the entity model
//@EnableJpaRepositories("com.story.Renting.Repository.BookRepository")
@SpringBootApplication
public class RentingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentingApplication.class, args);
	}

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.story.Renting")).build();
	}
}
