package com.choway.springboot.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;
import java.util.Random;


public class ActivemqTest {

	private static final String ACTIVEMQ_URL = "tcp://172.168.1.150:61616";


	/** activemq 发送消息 **/
	@Test
	public void sendMessage() {
		try {
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
			Connection connection = connectionFactory.createConnection();
			connection.start();

			Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue("test-queue");
			MessageProducer producer = session.createProducer(destination);

			TextMessage message = session.createTextMessage("test message : " + new Random().nextInt(100));
			producer.send(message);

			session.commit();
			session.close();
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}


	/** activemq 接收消息 **/
	@Test
	public void receiveMessage() {
		try {
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
			Connection connection = connectionFactory.createConnection();
			connection.start();

			Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue("test-queue");
			MessageConsumer consumer = session.createConsumer(destination);

			TextMessage message = (TextMessage) consumer.receive();
			System.out.println(message.getText());

			session.commit();
			session.close();
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
