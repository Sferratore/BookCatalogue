package com.FirstSpring.HelloWorld;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HelloWorld {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorld.class, args);
	}
	
	@RestController
	public static class HelloController {
		@GetMapping("/hello")
		public String hello() {
			return "Ciao, mondo!";
		}
	}

}
