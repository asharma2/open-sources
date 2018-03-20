package com.aks.cache.dao;

import java.util.List;

import com.aks.cache.model.Book;

public interface BookDao {

	List<Book> findAll();

}
