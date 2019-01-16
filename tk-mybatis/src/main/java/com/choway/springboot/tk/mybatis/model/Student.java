package com.choway.springboot.tk.mybatis.model;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Data
@Table(name = "tb_student")
public class Student {

	@Id
	@KeySql(useGeneratedKeys = true)
	private Long id;
	private String name;
	private Date createTime;

}
