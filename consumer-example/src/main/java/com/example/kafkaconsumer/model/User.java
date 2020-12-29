package com.example.kafkaconsumer.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private String name;
    private String department;
    private Long salary;
}
