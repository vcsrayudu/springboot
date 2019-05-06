package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/app")
public class MicrpStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrpStarterApplication.class, args);
	}
	@RequestMapping("/welcome/{calledFrom}")
	public String welcome(@PathVariable String calledFrom)
	{
		return "Welcome to Opentext "+calledFrom;
	}
}
