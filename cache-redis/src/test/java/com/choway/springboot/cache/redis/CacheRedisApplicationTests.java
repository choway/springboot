package com.choway.springboot.cache.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheRedisApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	public void test_findOne() {
		User user = userService.findOne(15);
	}

	@Test
	public void test_save() {
		User user = userService.findOne(15);
		user.setName("test"+ new Random().nextInt(100));
		userService.save(user);
	}

	@Test
	public void test_del() {
		User user = userService.findOne(16);
		userService.del(user);
	}

}

