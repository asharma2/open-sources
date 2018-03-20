package com.aks.cache.dao;

import java.util.List;

import com.aks.cache.model.User;

public interface UserDao {

	List<User> findAll();
}
