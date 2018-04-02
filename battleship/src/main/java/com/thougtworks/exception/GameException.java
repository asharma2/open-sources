package com.thougtworks.exception;

public class GameException extends Exception {
	private static final long serialVersionUID = 1L;

	public GameException() {
	}

	public GameException(String error) {
		super(error);
	}

	public GameException(Throwable cause) {
		super(cause);
	}

	public GameException(String error, Throwable cause) {
		super(error, cause);
	}

}
