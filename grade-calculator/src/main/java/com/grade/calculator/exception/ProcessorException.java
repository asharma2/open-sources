package com.grade.calculator.exception;

public class ProcessorException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProcessorException() {
	}

	public ProcessorException(String error) {
		super(error);
	}

	public ProcessorException(Throwable cause) {
		super(cause);
	}

	public ProcessorException(String error, Throwable cause) {
		super(error, cause);
	}

}
