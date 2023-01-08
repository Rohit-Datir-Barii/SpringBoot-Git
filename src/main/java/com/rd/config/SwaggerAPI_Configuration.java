package com.rd.config;

import java.util.Collections;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerAPI_Configuration {

	public Docket createDocket() {
		return  new Docket(DocumentationType.SWAGGER_2)  //UI screen type
				             .select()  //to specify  RestControllers
				             .apis(RequestHandlerSelectors.basePackage("com.rd.controller")) //base pkg for RestContrllers
				             .paths(PathSelectors.regex("/actor.*")) // to specify request paths
				             .build() // builds the Docket obj
				             .useDefaultResponseMessages(true)
				             .apiInfo(getApiInfo());
	}

	private  ApiInfo getApiInfo() {
		Contact contact=new Contact("Rohit Datir","http://www.rohit_da.com/actor","actor@gmail.com");
		return  new ApiInfo("Actor API",
				"Gives Information Actor Activites", 
				"3.4.RELEASE",
				"http://www.rohit_da.com/license",
				contact,
				"GNU Public",
				"http://apache.org/license/gnu", 
				Collections.emptyList());
	}
}

