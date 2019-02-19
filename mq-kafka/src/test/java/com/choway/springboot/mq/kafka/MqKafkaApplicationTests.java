package com.choway.springboot.mq.kafka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MqKafkaApplicationTests {

	@Autowired
	private KafkaSender kafkaSender;

	@Test
	public void sendMessage() throws InterruptedException {
		for (int i=0; i<10; i++) {
			kafkaSender.send();

			Thread.sleep(1000);
		}
	}

}
