package br.com.pratica.crudestudante.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.pratica.crudestudante.controllers"))				
				.paths(PathSelectors.any())
				.build()
				.apiInfo(new ApiInfo(
						"CRUD Estudante",
						"Projeto de estudo",
						"1.0.1",
						"",
						new Contact("url", "email", ""),
						"license",
						"license",
						new ArrayList<VendorExtension>()
						));
	}

	
}
