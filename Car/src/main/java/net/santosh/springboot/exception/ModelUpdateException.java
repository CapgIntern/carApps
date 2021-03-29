package net.santosh.springboot.exception;

public class ModelUpdateException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ModelUpdateException(String message) {
		super(message);
		
	}
}
