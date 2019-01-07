package com.choway.springboot.activemq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.JmsUtils;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.*;
import java.util.Random;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JmsTemplateTest {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private Queue queue;


	@Test
	public void sendMsg() {
		jmsTemplate.send(queue, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage message = session.createTextMessage("test msg : " + new Random().nextInt(100));
				message.setStringProperty("username", "test");
				return message;
			}
		});

		jmsTemplate.convertAndSend(queue, "test msg : " + new Random().nextInt(100));
	}

	@Test
	public void receiveMsg() {
		try {
			TextMessage message = (TextMessage) jmsTemplate.receive(queue);
			String text = message.getText();
			System.out.println(text);
		} catch (JMSException e) {
			throw JmsUtils.convertJmsAccessException(e);
		}
	}

}
