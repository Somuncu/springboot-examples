package com.example.consumer.service;

import com.example.consumer.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaListenerService {

    @KafkaListener(
            topics = "${proje.kafka.topic}",
            groupId = "${proje.kafka.group.id}"
    )
    public void listen(@Payload User message) {
        log.info("User received from consumer.. MessageID : {} Date : {}, name : {}, surname : {}"
                ,message.getId(),message.getCreatedAt(),message.getName(),message.getSurName());
    }
}
