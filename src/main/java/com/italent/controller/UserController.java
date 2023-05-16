package com.italent.controller;

import java.io.IOException;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.italent.entity.Customer;
import com.italent.exception.UserNotFoundException;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/getCustomer")
	public Customer getUserById(int id) throws UserNotFoundException {
		try {
			return restTemplate.getForObject("http://localhost:8083/account/getCustomer/1", Customer.class);
		} catch (HttpClientErrorException.NotFound e) {
			throw new UserNotFoundException("User not found with ID: " + id);
		} catch (Exception e) {
			throw new RuntimeException("Error while retrieving user with ID: " + id, e);
		}
	}

	@PostMapping("/createCustomer")
	public String createCustomer(@RequestBody Customer c) {

		restTemplate.getForObject("http://localhost:8083/account/createAccount", Customer.class);
		

		return "succesful inserted";

	}


}
