package com.example.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HelloWorldApplication {


    @RestController
    class HelloWorldController {

        @GetMapping("/{name}")
        String hello(@PathVariable String name) {
            return "Hello " + name + "!";
        }
    }
	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

}
