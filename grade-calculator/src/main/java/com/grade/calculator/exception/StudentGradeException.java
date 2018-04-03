package com.grade.calculator.exception;

public class StudentGradeException extends Exception {

	private static final long serialVersionUID = 1L;

	public StudentGradeException() {
	}

	public StudentGradeException(String error) {
		super(error);
	}

	public StudentGradeException(Throwable cause) {
		super(cause);
	}

	public StudentGradeException(String error, Throwable cause) {
		super(error, cause);
	}

}
