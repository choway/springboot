package com.choway.springboot.activemq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.JmsUtils;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.Random;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JmsTemplateTest {

	@Autowired
	private JmsTemplate jmsTemplate;


	@Test
	public void sendMsg() {
		jmsTemplate.send("queue.test", new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage message = session.createTextMessage("test msg : " + new Random().nextInt(100));
				return message;
			}
		});
	}

	@Test
	public void receiveMsg() {
		try {
			TextMessage message = (TextMessage) jmsTemplate.receive("queue.test");
			String text = message.getText();
			System.out.println(text);
		} catch (JMSException e) {
			throw JmsUtils.convertJmsAccessException(e);
		}
	}

}
