package com.kafkaexample.kafkaconsumer.controller;

import com.kafkaexample.kafkaconsumer.entity.Employee;
import com.kafkaexample.kafkaconsumer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employeeConsume")
public class ConsumeEmployee {

    @Autowired
    public EmployeeService employeeService;


    @GetMapping
    public List<String> consumeStringDataOnEmp(){
        List<String> strings = employeeService.consumeStringData();
        return strings;
    }

    @GetMapping("/empJson")
    public Employee consumeJsonDataOnEmp(){
        Employee employee = employeeService.consumeJsonObjectData();
        return employee;
    }

}
