package com.airtel.assigment.exception;

public class ApplicationException extends Exception {

	public ApplicationException(String error) {
		super(error);
	}

	public ApplicationException(Throwable cause) {
		super(cause);
	}

	private static final long serialVersionUID = 1L;

}
