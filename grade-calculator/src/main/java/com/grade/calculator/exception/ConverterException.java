package com.grade.calculator.exception;

public class ConverterException extends Exception {

	private static final long serialVersionUID = 1L;

	public ConverterException() {
	}

	public ConverterException(String error) {
		super(error);
	}

	public ConverterException(Throwable cause) {
		super(cause);
	}

	public ConverterException(String error, Throwable cause) {
		super(error, cause);
	}

}
