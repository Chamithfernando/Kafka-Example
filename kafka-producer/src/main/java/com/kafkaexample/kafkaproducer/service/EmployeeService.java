package com.kafkaexample.kafkaproducer.service;

import com.kafkaexample.kafkaproducer.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    private final String topic = "chamithKafka";

    public String publicTestMessage(String name){
        kafkaTemplate.send(topic,"Hi"+name+"welcome to our organization");
        return "data published";
    }

    public Employee publishEmployee(Employee employee){
        kafkaTemplate.send(topic,employee);
        return employee;
    }
}
