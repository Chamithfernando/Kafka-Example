package com.kafkaexample.kafkaconsumer;

import com.kafkaexample.kafkaconsumer.entity.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class KafkaConsumerApplication {


	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerApplication.class, args);
	}



}
