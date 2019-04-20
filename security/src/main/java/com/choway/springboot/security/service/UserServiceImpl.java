package com.choway.springboot.security.service;

import com.choway.springboot.security.model.User;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserServiceImpl implements UserService {


	@Override
	public User findByUsername(String username) {
		User user = new User();
		user.setId(new Random().nextLong());
		user.setUsername(username);
		user.setPassword("123456");
		user.setEnable(true);
		return user;
	}

}
