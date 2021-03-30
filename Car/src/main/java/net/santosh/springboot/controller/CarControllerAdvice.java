package net.santosh.springboot.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import net.santosh.springboot.exception.ModelAddException;
import net.santosh.springboot.exception.ModelDeleteException;
import net.santosh.springboot.exception.ModelEmptyListException;
import net.santosh.springboot.exception.ModelNotFoundException;
import net.santosh.springboot.exception.ModelUpdateException;

@RestControllerAdvice
public class CarControllerAdvice {
	@ExceptionHandler(ModelNotFoundException.class)
	public String carNotFoundException(Exception e1) {
		return e1.getMessage();

	}

	@ExceptionHandler(ModelUpdateException.class)
	public String carUpdateException(Exception e2) {
		return e2.getMessage();

	}

	@ExceptionHandler(ModelEmptyListException.class)
	public String carEmptyListException(Exception e3) {
		return e3.getMessage();

	}

	@ExceptionHandler(ModelDeleteException.class)
	public String carDeleteException(Exception e4) {
		return e4.getMessage();

	}

	@ExceptionHandler(ModelAddException.class)
	public String carAddException(Exception e5) {
		return e5.getMessage();

	}

}
