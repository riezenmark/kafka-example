package com.example.kafkaproducer.resource;

import com.example.kafkaproducer.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserResource {
    private final static String TOPIC = "Users";

    private final KafkaTemplate<String, User> userKafkaTemplate;

    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") String name) {
        userKafkaTemplate.send(TOPIC, new User(name, "IT", 500L));
        return "Published successfully";
    }
}
