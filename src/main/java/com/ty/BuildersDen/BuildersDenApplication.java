package com.ty.BuildersDen;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BuildersDenApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuildersDenApplication.class, args);
	}
	
	@Bean
	public Docket getDocket() {
		Contact contact=new Contact("TestYantra", "www.buildersden.com", "info@ty.com");
		List<VendorExtension> extensions=new ArrayList<VendorExtension>();
		
		ApiInfo apiInfo=new ApiInfo("Builders_Den_AppService", "Service To Manege Building Construction Items", "SNPSHOT 1.5", "www.buildersden.com", contact, "Licence 143", "www.buildingden.com", extensions);
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ty"))
				.build()
				.apiInfo(apiInfo)
				.useDefaultResponseMessages(false);
	}


}
