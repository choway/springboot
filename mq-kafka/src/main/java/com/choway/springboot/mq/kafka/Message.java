package com.choway.springboot.mq.kafka;

import lombok.Data;

import java.util.Date;


@Data
public class Message {

	private Long id;
	private String content;
	private Date time;

}
