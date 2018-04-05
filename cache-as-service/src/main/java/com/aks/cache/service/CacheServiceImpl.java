package com.aks.cache.service;

import java.util.List;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aks.cache.constants.Caches;
import com.aks.cache.dao.BookDao;
import com.aks.cache.dao.UserDao;
import com.aks.cache.exception.CacheException;
import com.aks.cache.model.Book;
import com.aks.cache.model.CacheResponse;
import com.aks.cache.model.User;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

@Service
public class CacheServiceImpl implements CacheService, InitializingBean, DisposableBean {

	@Autowired
	private BookDao bookDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private HazelcastInstance hazelcastInstance;

	private IMap<Caches, CacheResponse<?>> caches;

	@Override
	public void start() throws CacheException {
	}

	@Override
	public CacheResponse<?> getCacheResponse(Caches caches) throws CacheException {
		return this.caches.get(caches);
	}

	@Override
	public void stop() throws CacheException {
	}

	@Override
	public void destroy() throws Exception {

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		caches = hazelcastInstance.getMap("caches");
		caches.put(Caches.Book, new CacheResponse<List<Book>>(Caches.Book, bookDao.findAll()));
		caches.put(Caches.User, new CacheResponse<List<User>>(Caches.User, userDao.findAll()));
	}

}
