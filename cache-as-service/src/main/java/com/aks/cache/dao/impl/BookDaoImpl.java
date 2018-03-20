package com.aks.cache.dao.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.aks.cache.dao.BookDao;
import com.aks.cache.model.Book;

@Repository
public class BookDaoImpl implements BookDao {

	@Override
	public List<Book> findAll() {
		return Arrays.asList(
				new Book("1-56619-909-3", "Enterprise Integration Pattern", "Martin Fowler", new Date()),
				new Book("1-56619-909-4", "Java Concurrency", "Josh Blosch", new Date()),
				new Book("1-56619-909-5", "Java Puzzler", "Josh Blosch", new Date()),
				new Book("1-56619-909-6", "Thinking In Java", "Bruce Eckel", new Date()),
				new Book("1-56619-909-7", "Lucene In Action", "Orielly", new Date()),
				new Book("1-56619-909-8", "Spring In Action", "Pivotal", new Date()));
	}

}
