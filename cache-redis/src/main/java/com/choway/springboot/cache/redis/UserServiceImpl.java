package com.choway.springboot.cache.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;


	@Cacheable(value = "user", key = "#id", unless = "#result eq null")
	@Override
	public User findOne(Integer id) {
		Optional<User> userOptional = userDao.findById(id);
		return userOptional.get();
	}

	@CachePut(value = "user", key = "#user.id")
	@Override
	public User save(User user) {
		return userDao.save(user);
	}

	@CacheEvict(value = "user", key = "#user.id")
	@Override
	public void del(User user) {
		userDao.delete(user);
	}

}
