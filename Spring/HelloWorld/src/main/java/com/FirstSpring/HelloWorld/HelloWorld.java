package com.FirstSpring.HelloWorld;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*Imports done manually, ignore Eclipse's objections*/
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication  //Annotation which defines that "HelloWorld" class is a Spring Boot application.
public class HelloWorld {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorld.class, args);  //Running he "HelloWorld" class as Spring Boot application as first thing.
	}
	
	@RestController //Annotation which defines that "HelloController" is a REST controller inside the application
	public static class HelloController {
		@GetMapping("/hello")  //GetMapping defines which GET call is used to call the underlying method.
		public String hello() {
			return "Hello, world!";
		}
	}

}
