package com.grabit.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.grabit.common.entity","com.grabit.admin.user"})
public class GrabitBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrabitBackEndApplication.class, args);
	}

}
