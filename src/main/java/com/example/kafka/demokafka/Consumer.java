package com.example.kafka.demokafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    private static final Logger log = LoggerFactory.getLogger(Producer.class);

    @KafkaListener(topics = "users", groupId = "group-id")
    public void consume(String message) {
        log.info(String.format("Message consumed[%s]", message));
    }
}
