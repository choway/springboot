package com.choway.springboot.tk.mybatis.dao;

import com.choway.springboot.tk.mybatis.model.Student;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Random;


@Slf4j
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

	@Test
	public void test_page_by_row_bounds() {
		int page = 2;
		int size = 5;
		int offset = (page-1)*size;

		studentMapper.selectByRowBounds(null, new RowBounds(offset, 5));
	}

	@Test
	public void test_page_helper() {
		int page = 2;
		int size = 5;
		Page<Student> studentPage = PageHelper.startPage(page, size);

		log.info("student page = {}", studentPage);
		log.info("current page num = {}", studentPage.getPageNum());

		studentMapper.selectAll();
	}

}
