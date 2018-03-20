package com.aks.cache.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.aks.cache.constants.Caches;
import com.aks.cache.dao.BookDao;
import com.aks.cache.dao.UserDao;
import com.aks.cache.exception.CacheException;
import com.aks.cache.model.Book;
import com.aks.cache.model.CacheResponse;
import com.aks.cache.model.User;
import com.hazelcast.core.IMap;

@Service
public class CacheServiceImpl implements CacheService {

	@Autowired
	private BookDao bookDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	@Qualifier("caches")
	private IMap<Caches, CacheResponse<?>> caches;

	@Override
	@PostConstruct
	public void start() throws CacheException {
		caches.put(Caches.Book, new CacheResponse<List<Book>>(Caches.Book, bookDao.findAll()));
		caches.put(Caches.User, new CacheResponse<List<User>>(Caches.User, userDao.findAll()));
	}

	@Override
	public CacheResponse<?> getCacheResponse(Caches caches) throws CacheException {
		return this.caches.get(caches);
	}

	@Override
	@PreDestroy
	public void stop() throws CacheException {
		caches.clear();
	}

}
