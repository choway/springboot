package com.choway.springboot.elasticsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;


	@Override
	public void save(Student student) {
		studentDao.save(student);
	}

	@Override
	public void delete(long id) {
		studentDao.deleteById(id);
	}

	@Override
	public Student getOne(long id) {
		Optional<Student> optional = studentDao.findById(id);
		return optional.get();
	}

}
