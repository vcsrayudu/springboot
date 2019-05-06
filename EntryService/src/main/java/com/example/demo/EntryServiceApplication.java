package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RequestMapping("/entry")
@EnableDiscoveryClient
public class EntryServiceApplication {
	@Autowired
	private RestTemplate restTemplate;
	public static void main(String[] args) {
		SpringApplication.run(EntryServiceApplication.class, args);
	}
	@RequestMapping("/localwelcome")
	public String localwelcome()
	{
		return "Welcome to Local Opentext";
	}
	@RequestMapping("/welcome")
	public String welcome()
	{
		String calledFrom="Entry Service";
		String responce =restTemplate.exchange("http://localhost:8081/app/welcome/{calledFrom}", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, calledFrom).getBody();
		return responce;
	}
	@RequestMapping("/welcome2")
	public String welcome2()
	{
		String calledFrom="Entry Service2";
		String responce =restTemplate.exchange("http://microstarter/app/welcome/{calledFrom}", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, calledFrom).getBody();
		return responce;
	}
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
}
