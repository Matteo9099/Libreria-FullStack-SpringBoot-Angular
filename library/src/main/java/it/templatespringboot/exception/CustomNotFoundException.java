package it.templatespringboot.exception;

public class CustomNotFoundException extends RuntimeException {

	/** */
	private static final long serialVersionUID = 1L;

	public CustomNotFoundException(String message) {
		super(message);
	}
}
