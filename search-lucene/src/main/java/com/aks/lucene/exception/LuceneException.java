package com.aks.lucene.exception;

public class LuceneException extends Exception {

	private static final long serialVersionUID = 1L;

	public LuceneException(String error) {
		super(error);
	}

	public LuceneException(Throwable cause) {
		super(cause);
	}

}
