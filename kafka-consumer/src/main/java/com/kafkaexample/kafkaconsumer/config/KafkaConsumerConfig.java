package com.kafkaexample.kafkaconsumer.config;

import com.kafkaexample.kafkaconsumer.entity.Employee;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {

    // consumerFactory and concurrent kafkaListener for String Object / String value.
    @Bean
    public ConsumerFactory<String, String> consumerFactory(){
        Map<String, Object> configmap = new HashMap<>();
        configmap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        configmap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configmap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configmap.put(ConsumerConfig.GROUP_ID_CONFIG, "stringObjectGroup10");
        return new DefaultKafkaConsumerFactory<>(configmap);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }


    // consumerFactory and concurrent kafkaListener for Json Object.(Employee)
    @Bean
    public ConsumerFactory<String, Employee> employeeConsumerFactory(){

        JsonDeserializer<Employee> deserializer = new JsonDeserializer<>(Employee.class);
        deserializer.setRemoveTypeHeaders(false);
        deserializer.addTrustedPackages("*");
        deserializer.setUseTypeMapperForKey(true);

        Map<String, Object> configmap = new HashMap<>();
        configmap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        configmap.put(ConsumerConfig.GROUP_ID_CONFIG, "jsonObjectGroup10");
        configmap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        configmap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        configmap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configmap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);

        return new DefaultKafkaConsumerFactory<>(configmap, new StringDeserializer(),deserializer);
    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Employee> employeeKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, Employee> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(employeeConsumerFactory());
        return factory;
    }
}
