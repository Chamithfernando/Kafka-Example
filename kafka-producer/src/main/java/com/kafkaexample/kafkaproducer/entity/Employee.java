package com.kafkaexample.kafkaproducer.entity;

import lombok.Data;
import java.util.UUID;

@Data
public class Employee {


    private UUID id = UUID.randomUUID();
    private String name;
    private Integer age;
    private String address;

    public Employee() {
    }

    public Employee(UUID id, String name, Integer age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
