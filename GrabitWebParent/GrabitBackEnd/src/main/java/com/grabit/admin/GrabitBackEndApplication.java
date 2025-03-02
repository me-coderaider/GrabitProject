package com.grabit.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EntityScan({"com.grabit.common.entity","com.grabit.admin.user"})
public class GrabitBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrabitBackEndApplication.class, args);
	}

//    @Bean
//    WebMvcConfigurer corsConfigurer() {
//	    return new WebMvcConfigurer() {
//	      @Override
//	      public void addCorsMappings(CorsRegistry registry) {
//	       registry.addMapping("/**").allowedOrigins("http://localhost:8080")
//	                      .allowedMethods("PUT", "DELETE", "GET", "POST");
//	      }
//	    };
//	  }

}
