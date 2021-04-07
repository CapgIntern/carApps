package net.santosh.springboot.exception;

public class ModelEmptyListException extends RuntimeException {

	/**************************************************************************
	 * @author                 R saisantosh kumar reddy
	 * Description             It is an exception class that handles the exception that occurs at 
	 *                         service level
	 * version                 1.0
	 * created date            25-03-2021
	 *
	 ************************************************************************************/
	private static final long serialVersionUID = 1L;

	public ModelEmptyListException(String message) {
		super(message);

	}

}
