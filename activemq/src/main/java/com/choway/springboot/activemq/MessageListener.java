package com.choway.springboot.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class MessageListener {

	@JmsListener(destination = "queue.test")
	public void processMsg(String content) {
		System.out.println(content);
	}

}
