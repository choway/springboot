package com.choway.springboot.activemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;


@Configuration
@EnableJms
public class ActiveMQConfig {

	@Bean
	public Queue queue() {
		ActiveMQQueue queue = new ActiveMQQueue("queue.test");
		return queue;
	}

}
