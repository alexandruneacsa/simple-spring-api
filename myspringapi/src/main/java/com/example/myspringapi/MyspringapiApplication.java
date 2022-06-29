/*Spring Boot App V1*/
/*Author: Neacsa Alexandru*/
package com.example.myspringapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MyspringapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyspringapiApplication.class, args);
	}
}
