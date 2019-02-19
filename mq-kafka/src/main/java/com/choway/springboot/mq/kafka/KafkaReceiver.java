package com.choway.springboot.mq.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class KafkaReceiver {

	@KafkaListener(topics = "test-topic")
	public void listen(ConsumerRecord<?, ?> record) {
		log.info("kafka -> topic={}", record.topic());
		log.info("kafka -> key={}", record.key());
		log.info("kafka -> value={}", record.value());
	}

}
