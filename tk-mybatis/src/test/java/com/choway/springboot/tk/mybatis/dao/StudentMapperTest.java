package com.choway.springboot.tk.mybatis.dao;

import com.choway.springboot.tk.mybatis.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Random;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentMapperTest {

	@Autowired
	private StudentMapper studentMapper;

	@Test
	public void test_insert() {
		Student student = new Student();
		student.setName("student" + new Random().nextInt(100));
		student.setCreateTime(new Date());
		studentMapper.insert(student);

		System.out.println(student.getId());
	}

	@Test
	public void test_delete() {
		studentMapper.deleteByPrimaryKey(1);
	}

	@Test
	public void test_select_update() {
		Student student = studentMapper.selectByPrimaryKey(2);
		student.setName("student" + new Random().nextInt(100));
		studentMapper.updateByPrimaryKey(student);
	}

}
