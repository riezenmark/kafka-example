package com.example.kafkaconsumer.listener;

import com.example.kafkaconsumer.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "Messages", groupId = "group_id", containerFactory = "messageKafkaListenerContainerFactory")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }

    @KafkaListener(topics = "Users", groupId = "group_id", containerFactory = "userKafkaListenerContainerFactory")
    public void consume(User user) {
        System.out.println("Consumed JSON message: " + user);
    }
}
