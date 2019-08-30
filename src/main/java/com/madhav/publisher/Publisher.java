package com.madhav.publisher;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Publisher {

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public void produceMessage(String msg) {
		amqpTemplate.convertAndSend("E1", "RK1", msg);
	}
}
