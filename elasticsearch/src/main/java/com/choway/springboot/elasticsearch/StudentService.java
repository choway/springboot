package com.choway.springboot.elasticsearch;

public interface StudentService {

	void save(Student student);

	void delete(long id);

	Student getOne(long id);

}
