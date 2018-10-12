package com.gimnazijam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.gimnazijam.controllers.ZaposleniController;

@SpringBootApplication
@ComponentScan(basePackageClasses = ZaposleniController.class)
public class GimnazijaMApplication {

	public static void main(String[] args) {
		SpringApplication.run(GimnazijaMApplication.class, args);
	}

}
