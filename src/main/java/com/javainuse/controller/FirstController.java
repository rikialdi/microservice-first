package com.javainuse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.junit.Assert.assertEquals;

@RestController
@RequestMapping("/employee")
public class FirstController {

	@Bean
	public TestRestTemplate restTemplate(){
		return new   TestRestTemplate();
	}

	@GetMapping("/message")
	public String test() {
		callServiceEmployee();
		return "Hello JavaInUse Called in First Service and Called in Second Service";
	}

	public void callServiceEmployee() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "*/*");
		headers.set("Content-Type", "application/json");
		String url = "http://localhost:8082/consumer/message";
		ResponseEntity<String> exchange = restTemplate().exchange(url, HttpMethod.GET, null, String.class);

		System.out.println("response dari service 2  =" + exchange.getBody());
		assertEquals(HttpStatus.OK, exchange.getStatusCode());
	}
}
