package com.choway.springboot.mq.kafka;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;


@Component
public class KafkaSender {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void send() {
		Message message = new Message();
		message.setId(System.currentTimeMillis());
		message.setContent("message_" + new Random().nextInt(1000));
		message.setTime(new Date());

		kafkaTemplate.send("test-topic", "testmsg", JSON.toJSONString(message));
	}

}
