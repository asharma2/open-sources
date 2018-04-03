package com.grade.calculator.exception;

public class ReaderException extends Exception {

	private static final long serialVersionUID = 1L;

	public ReaderException() {
	}

	public ReaderException(String error) {
		super(error);
	}

	public ReaderException(Throwable cause) {
		super(cause);
	}

	public ReaderException(String error, Throwable cause) {
		super(error, cause);
	}

}
