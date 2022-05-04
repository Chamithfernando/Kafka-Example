package com.kafkaexample.kafkaproducer.service;

import com.kafkaexample.kafkaproducer.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, Employee> employeeKafkaTemplate;

    private String topic = "chamithKafkaNew";
    private String topic2 = "chamithKafkaNewUpdate";

    public String publicTestMessage(String name){
        kafkaTemplate.send(topic,"Hi"+name+"welcome to our organization");
        return "data published";
    }

    public Employee publishEmployee(Employee employee){
        employeeKafkaTemplate.send(topic2,employee);
        return employee;
    }
}
