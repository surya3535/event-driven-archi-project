package com.producer;

import java.util.Date;
import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagePublisher {

	@Autowired
	private RabbitTemplate template;

	@PostMapping("/publish")
	public String publishMessage(@RequestBody CustomMessage message) {
		message.setMId(UUID.randomUUID().toString());
		message.setMDate(new Date());
		template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, message);
		return "Mesage published";
	}

}
