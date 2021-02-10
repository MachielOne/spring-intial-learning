package org.homeboy.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author Tintin-Mask
 */
@SpringBootApplication
@ServletComponentScan(basePackages = "org.homeboy.spring.web.servlet")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
