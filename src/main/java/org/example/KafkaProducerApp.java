package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerApp {
    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApp.class, args);
    }
}