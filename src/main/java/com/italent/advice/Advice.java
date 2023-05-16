package com.italent.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.HttpServerErrorException;

import com.italent.exception.UserNotFoundException;

@RestControllerAdvice
public class Advice {

	public Map<String, String> NotValueFound() {

		Map<String, String> errorMap = new HashMap<String, String>();

		return errorMap;
	}

	@ExceptionHandler(UserNotFoundException.class)
	public Map<String, String> NoValueFound(UserNotFoundException ex) {

		Map<String, String> errorMap = new HashMap<String, String>();
		errorMap.put("error message", ex.getMessage());

		return errorMap;
	}

	@ExceptionHandler(HttpClientErrorException.class)
	public Map<String, String> NoValueFound(HttpClientErrorException ex) {

		Map<String, String> errorMap = new HashMap<String, String>();
		errorMap.put("error message", "value not found");

		return errorMap;
	}

	@ExceptionHandler(HttpServerErrorException.class)
	public Map<String, String> NoValueFound(HttpServerErrorException ex) {

		Map<String, String> errorMap = new HashMap<String, String>();
		errorMap.put("error message", "value not found");

		return errorMap;
	}
}
