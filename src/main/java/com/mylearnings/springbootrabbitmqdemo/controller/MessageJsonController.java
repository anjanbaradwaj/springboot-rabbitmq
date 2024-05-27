package com.mylearnings.springbootrabbitmqdemo.controller;

import com.mylearnings.springbootrabbitmqdemo.dto.User;
import com.mylearnings.springbootrabbitmqdemo.publisher.RabbitMQJsonProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class MessageJsonController {

    private RabbitMQJsonProducer rabbitMQJsonProducer;

    @Autowired
    public MessageJsonController(RabbitMQJsonProducer rabbitMQJsonProducer) {
        this.rabbitMQJsonProducer = rabbitMQJsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        rabbitMQJsonProducer.sendJsonMesage(user);
        return ResponseEntity.ok("JSON message sent to RabbitMQ");
    }
}
