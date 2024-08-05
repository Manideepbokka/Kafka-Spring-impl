package org.example.controller;

import org.example.dao.Customer;
import org.example.dao.User;
import org.example.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer-app")
public class PublisherController {

    @Autowired
    ProducerService producerService;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable String message){
        try{
            for(int i=0;i<100000;i++){
                producerService.publishMessageToTopic(message + " : " + i);
            }
            return ResponseEntity.ok("Message Successfully Sent");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/publish/Customer")
    public ResponseEntity<?> publishCustomer(@RequestBody Customer customer){
        try{
            System.out.println("----------------------");
            producerService.publishCustomerMessageToTopic(customer);
            return ResponseEntity.ok("Customer Data Published");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/publish/User")
    public ResponseEntity<?> publishUser(@RequestBody User user){
        try{
            producerService.publishUserMessageToKafkaTopic(user);
            return ResponseEntity.ok("User Data Published");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
