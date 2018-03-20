package com.aks.cache.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aks.cache.constants.Caches;
import com.aks.cache.exception.CacheException;
import com.aks.cache.model.CacheResponse;
import com.aks.cache.service.CacheService;

@Controller
@RequestMapping("/api/cache")
public class CacheApiController {

	@Autowired
	private CacheService cacheService;

	@GetMapping("/books")
	@ResponseBody
	public CacheResponse<?> books() throws CacheException {
		return cacheService.getCacheResponse(Caches.Book);
	}

	@GetMapping("/users")
	@ResponseBody
	public CacheResponse<?> users() throws CacheException {
		return cacheService.getCacheResponse(Caches.User);
	}

}
