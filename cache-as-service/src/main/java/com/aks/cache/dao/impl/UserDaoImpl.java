package com.aks.cache.dao.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.aks.cache.dao.UserDao;
import com.aks.cache.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Override
	public List<User> findAll() {
		return Arrays.asList(new User(1, "Atul", "Sharma", "atulkumarsharma1986@gmail.com", new Date()),
				new User(1, "Vipul", "Sharma", "vipulkumar731@gmail.com", new Date()),
				new User(1, "Sakshi", "Agrawal", "s.agrawal8915@gmail.com", new Date()),
				new User(1, "Pankaj", "Agrawal", "pankaj7a@rediffmail.com", new Date()));
	}

}
