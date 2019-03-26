package com.choway.springboot.security.jwt;

import com.choway.springboot.security.jwt.util.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityJwtApplicationTests {

	@Test
	public void test_generateToken() {
		String id = "123456";
		String name = "choway";
		String token = JwtUtil.generateToken(id, name);
		System.out.println(token);
	}

	@Test
	public void test_parseToken() {
		String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMjM0NTYiLCJzdWIiOiJqd3QgdG9rZW4iLCJhdWQiOiJ1c2VyIiwiaXNzIjoiY2hvd2F5IiwiaWF0IjoxNTUzNTg2NzQ1LCJuYmYiOjE1NTM1ODY3NDUsImV4cCI6MTU1MzU5Mzk0NX0.qtZzHExFe5YnuHNRYWSu7eb5x3LWhMkQbg1KYOU_Cw8";
		Claims claims = JwtUtil.parseToken(token);

		log.info("claims={}", claims);
	}

}
