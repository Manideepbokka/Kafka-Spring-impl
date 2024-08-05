package org.example.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.example.dao.Customer;
import org.example.dao.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;



@Service
public class ConsumerService {

    private static final Logger logger= (Logger) LoggerFactory.getLogger(ConsumerService.class);

    @KafkaListener(topics = "${kafka.topic.name1}",groupId = "my-consumer-group1")
    public void listenAndProcessMessage(String message){
        logger.info("Consumer recieved message=["+message+"]");
    }

    @KafkaListener(topics = "${kafka.topic.name2}",groupId = "my-consumer-group-2", containerFactory = "customerConsumer")
    public void listenAndProcessCustomerMessage(Customer customer){
        //ConsumerRecord<String, Customer> consumerRecord, Acknowledgment acknowledgment
        try{
            logger.info("Consumer received Customer message=["+ customer +"]");
            //acknowledgment.acknowledge();
        }catch (Exception e) {
            logger.error("Exception while consuming event: {}", e.getMessage());
        }
    }

    @RetryableTopic(attempts = "4", backoff = @Backoff(delay = 3000, multiplier = 1.5, maxDelay = 15000),
    exclude = {NullPointerException.class})
    @KafkaListener(topics = "MovieBookUsers",groupId = "my-consumer-group4", containerFactory = "userContainerFactory",
            topicPartitions={@TopicPartition(topic="MovieBookUsers",
                    partitions={"2"})})
    public void listenAndProcessUserMessage(User user){
        try{
            if(user.getEmail().equals("saimanideep159@gmail.com")){
               throw new RuntimeException("email doesnt work");
            }
            logger.info("Consumer received User message=["+ user +"]");
        }catch (Exception e){
            logger.error("Exception while consuming event: {}", e.getMessage());
        }
    }

    @DltHandler
    public void dltHandler(User user) {
        System.out.println("Received message in dead letter topic: " + user);
        // Handle the message from the dead letter topic
    }
}
