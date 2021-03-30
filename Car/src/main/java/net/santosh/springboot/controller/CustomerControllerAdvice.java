package net.santosh.springboot.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import net.santosh.springboot.exception.ModelNotFoundException;

@RestControllerAdvice
public class CustomerControllerAdvice {
	@ExceptionHandler(ModelNotFoundException.class)
	public String productException(Exception e) {
		return e.getMessage();
	}
}
