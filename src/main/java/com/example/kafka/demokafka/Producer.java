package com.example.kafka.demokafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    private static final String KAFKA_TOPIC = "users";
    private static final Logger log = LoggerFactory.getLogger(Producer.class);

    private final KafkaTemplate<String, User> kafkaTemplate;

    @Autowired
    public Producer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String username) {
        log.info(String.format("Producing username[%s]", username));
        final User user = User.newBuilder()
                              .setUserId(1)
                              .setUsername(username)
                              .setFirstName("Joe")
                              .setLastName("Average")
                              .build();
//        kafkaTemplate.send(new ProducerRecord<>(KAFKA_TOPIC, user)); option 1
        kafkaTemplate.send(KAFKA_TOPIC, user); // option 2
    }
}
