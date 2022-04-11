package com.example.producer.controller;

import com.example.producer.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import java.util.UUID;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class ResourceController {

    @Value("${proje.kafka.topic}")
    private String topic;

    private final KafkaTemplate<String, User> kafkaTemplate;

    @PostMapping
    public void sendMessage(@RequestBody User user) {

        kafkaTemplate.send(topic, UUID.randomUUID().toString(), user);
    }
}
