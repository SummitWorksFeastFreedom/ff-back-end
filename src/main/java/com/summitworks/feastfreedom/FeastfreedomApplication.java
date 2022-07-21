package com.summitworks.feastfreedom;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan("com.summitworks")
@EnableJpaRepositories("com.summitworks.repository")
@EntityScan("com.summitworks.model")
@EnableSwagger2
@SpringBootApplication
public class FeastfreedomApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeastfreedomApplication.class, args);
	}

}
