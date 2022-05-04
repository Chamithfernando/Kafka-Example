package com.kafkaexample.kafkaconsumer.service;

import com.kafkaexample.kafkaconsumer.entity.Employee;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    Employee employeeObj = null;
    List<String> stringDataList = new ArrayList<>();

    public List<String> consumeStringData(){
        return stringDataList;
    }
    public Employee consumeJsonObjectData(){
        return employeeObj;
    }

    @KafkaListener(groupId = "stringObjectGroup10",topics = "chamithKafkaNew", containerFactory = "kafkaListenerContainerFactory")
    public List<String> consumeString(String data){
        stringDataList.add(data);
        return stringDataList;
    }

    @KafkaListener(groupId = "jsonObjectGroup1",topics = "chamithKafkaNewUpdate", containerFactory = "employeeKafkaListenerContainerFactory")
    public Employee consumeJsonObj(Employee employee){
        employeeObj = employee;
        return employeeObj;
    }


}
