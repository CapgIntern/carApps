package net.santosh.springboot.exception;

public class UserModuleException extends RuntimeException {
	public UserModuleException(String ExceptionMessage) {
		super(ExceptionMessage);
	}

}
