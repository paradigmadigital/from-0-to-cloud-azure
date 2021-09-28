package com.paradigmadigital.watto.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;

@EnableOpenApi
@Import({ SpringDataRestConfiguration.class, BeanValidatorPluginsConfiguration.class })
public class SpringFoxConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.OAS_30).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.paradigmadigital.watto.order"))
				.paths(PathSelectors.ant("/*")).build().useDefaultResponseMessages(false);
	}

	@Bean
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Watto Shop API").license("").licenseUrl("").termsOfServiceUrl("")
				.version("1.0").build();
	}
}