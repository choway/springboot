package com.choway.springboot.mybatis;

import com.choway.springboot.mybatis.dao.UserMapper;
import com.choway.springboot.mybatis.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Random;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void test_mybatis() {
		User user = new User();
		user.setName("test"+new Random().nextInt(100));
		user.setCreateTime(new Date());
		userMapper.insert(user);
	}

}
