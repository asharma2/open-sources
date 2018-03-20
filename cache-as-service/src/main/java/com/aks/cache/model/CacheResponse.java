package com.aks.cache.model;

import java.io.Serializable;

import com.aks.cache.constants.Caches;

public class CacheResponse<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	protected Caches caches;
	protected T response;

	public CacheResponse(Caches caches, T response) {
		this.caches = caches;
		this.response = response;
	}

	public Caches getCaches() {
		return caches;
	}

	public T getResponse() {
		return response;
	}

}
