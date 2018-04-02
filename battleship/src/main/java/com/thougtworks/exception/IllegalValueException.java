package com.thougtworks.exception;

public class IllegalValueException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public IllegalValueException() {
	}

	public IllegalValueException(String error) {
		super(error);
	}

	public IllegalValueException(Throwable cause) {
		super(cause);
	}

	public IllegalValueException(String error, Throwable cause) {
		super(error, cause);
	}

}
