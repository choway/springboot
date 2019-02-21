package com.choway.springboot.elasticsearch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchApplicationTests {

	@Autowired
	private StudentService studentService;

	@Test
	public void save() {
		Student student = new Student();
		student.setId(System.currentTimeMillis());
		student.setName("student:" + new Random().nextInt(1000));
		student.setAge(new Random().nextInt(50));
		student.setCreateTime(new Date());
		studentService.save(student);
	}

	@Test
	public void delete() {
		long id = 1550722240522L;
		studentService.delete(id);
	}

	@Test
	public void getOne() {
		long id = 1550722219012L;
		Student student = studentService.getOne(id);
	}
}
