package com.github.mra9776.saving_privates_bike;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Component
@EnableSwagger2
public class SwaggerConfig {
	public final Contact DEFAULT_CONTACT = new Contact("Mohammad Reza Ahmadi", "https://github.com/mra9776/saving_privates_bike", "mra9776@gmail.com");
	public final ApiInfo DEFAULT = new ApiInfo("Saving Private's Bike Documentation", "Api Documentation", "1.0", "",
			DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	private final Set<String> DEFAULT_PRODUCE_AND_CONSUMES = new HashSet<String>(Arrays.asList("application/json"));

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT)
				.produces(DEFAULT_PRODUCE_AND_CONSUMES)
				.consumes(DEFAULT_PRODUCE_AND_CONSUMES);
				
	}

}
