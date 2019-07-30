package com.example.kafka.demokafka;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaEndpoint {
    private final Producer producer;

    public KafkaEndpoint(Producer producer) {this.producer = producer;}

    @PostMapping("/publish")
    public void sendUsername(@RequestParam("name") String name) {
        producer.sendMessage(name);
    }
}
