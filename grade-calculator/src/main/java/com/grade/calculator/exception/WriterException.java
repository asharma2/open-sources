package com.grade.calculator.exception;

public class WriterException extends Exception {

	private static final long serialVersionUID = 1L;

	public WriterException() {
	}

	public WriterException(String error) {
		super(error);
	}

	public WriterException(Throwable cause) {
		super(cause);
	}

	public WriterException(String error, Throwable cause) {
		super(error, cause);
	}

}
