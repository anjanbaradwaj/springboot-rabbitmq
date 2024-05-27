package com.mylearnings.springbootrabbitmqdemo.publisher;

import com.mylearnings.springbootrabbitmqdemo.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonProducer.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.json.routing.key}")
    private String jsonRoutingKey;

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMesage(User user){
        LOGGER.info(String.format("JSON message sent -> %s ", user.toString()));
        rabbitTemplate.convertAndSend(exchange, jsonRoutingKey, user);
    }
}
