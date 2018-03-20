package com.aks.cache.exception;

public class CacheException extends Exception {

	private static final long serialVersionUID = 1L;

	public CacheException() {
	}

	public CacheException(String error) {
		super(error);
	}

	public CacheException(Throwable cause) {
		super(cause);
	}

	public CacheException(String error, Throwable cause) {
		super(error, cause);
	}

}
