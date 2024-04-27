package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import com.example.demo.dto.User;

@Service
public class MyService {
	
	Logger logger=LoggerFactory.getLogger(MyService.class);
	
	//listening to a particular partition
	@KafkaListener(topics="JavaTopic",groupId = "groupId3",
			topicPartitions= {@TopicPartition(topic="JavaTopic",partitions= {"1"})})
	public void consumeMessage(User user) {
		logger.info(user.toString());
	}

}
