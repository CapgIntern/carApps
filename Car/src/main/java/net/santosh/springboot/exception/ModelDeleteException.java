package net.santosh.springboot.exception;

public class ModelDeleteException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ModelDeleteException (String message) {
		super(message);
		
	}

}
