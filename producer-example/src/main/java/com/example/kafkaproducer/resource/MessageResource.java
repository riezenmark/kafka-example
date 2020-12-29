package com.example.kafkaproducer.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("message")
@RequiredArgsConstructor
public class MessageResource {
    private final static String TOPIC = "Messages";

    private final KafkaTemplate<String, String> messageKafkaTemplate;

    @GetMapping("/publish/{message}")
    public String post(@PathVariable("message") final String message) {
        messageKafkaTemplate.send(TOPIC, message);
        return "Published successfully";
    }

}
