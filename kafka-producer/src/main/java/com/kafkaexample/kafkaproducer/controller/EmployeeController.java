package com.kafkaexample.kafkaproducer.controller;

import com.kafkaexample.kafkaproducer.entity.Employee;
import com.kafkaexample.kafkaproducer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;

    @GetMapping("/simple/{name}")
    public String publishSimple(@PathVariable String name){
        return employeeService.publicTestMessage(name);
    }

    @PostMapping
    public ResponseEntity<Employee> publishEmpObj(@RequestBody Employee employee){
        employeeService.publishEmployee(employee);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
