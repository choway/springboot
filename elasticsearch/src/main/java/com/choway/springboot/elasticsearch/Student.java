package com.choway.springboot.elasticsearch;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;


@Data
@Document(indexName = "test_index", type = "student")
public class Student {

	private long id;
	private String name;
	private int age;
	private Date createTime;

}
