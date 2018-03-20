package com.aks.cache.service;

import com.aks.cache.constants.Caches;
import com.aks.cache.exception.CacheException;
import com.aks.cache.model.CacheResponse;

public interface CacheService {

	void start() throws CacheException;

	CacheResponse<?> getCacheResponse(Caches caches) throws CacheException;

	void stop() throws CacheException;
}
