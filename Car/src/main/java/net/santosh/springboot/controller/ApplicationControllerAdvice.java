package net.santosh.springboot.controller;

import net.santosh.springboot.exception.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestControllerAdvice
public class ApplicationControllerAdvice {
	@ExceptionHandler({ CustomerNotFoundException.class, ModelAddException.class, ModelDeleteException.class,
			ModelEmptyListException.class, ModelNotFoundException.class, ModelUpdateException.class,
			ResourceNotFoundException.class, UserModuleException.class })

	public ResponseEntity<String> carApplication(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

}
