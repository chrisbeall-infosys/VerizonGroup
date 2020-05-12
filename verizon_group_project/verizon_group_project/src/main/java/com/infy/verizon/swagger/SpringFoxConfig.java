package com.infy.verizon.swagger;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2)  
		          .select()                                  
		          .apis(RequestHandlerSelectors.any())              
		          .paths(PathSelectors.any())                          
		          .build()
		          .apiInfo(apiDetails());  
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Verizon Flights API",
				"API for Verizon Group Project",
				"1.0",
				"Access enable",
				new springfox.documentation.service.Contact("Verizon Group Project", "https://github.com/chrisbeall-infosys/VerizonGroup", "thu.vuong@infosys.com"),
				"API Licence",
				"https://github.com/chrisbeall-infosys/VerizonGroup",
				Collections.emptyList());
	}

}
