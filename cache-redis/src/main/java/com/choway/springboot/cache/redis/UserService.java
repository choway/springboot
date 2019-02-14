package com.choway.springboot.cache.redis;

public interface UserService {

	User findOne(Integer id);

	User save(User user);

	void del(User user);

}
