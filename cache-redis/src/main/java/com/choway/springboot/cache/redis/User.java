package com.choway.springboot.cache.redis;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Data
@Entity
@Table(name = "tb_user")
public class User implements Serializable {

	@Id
	private Integer id;
	private String name;
	private Date createTime;

}
