package org.example.service;

import org.example.dao.Customer;
import org.example.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class ProducerService {

    @Value("${kafka.topic.name1: null}")
    private String topicName1;

    @Value("${kafka.topic.name2: null}")
    private String topicName2;

    private final  KafkaTemplate<String, Object> kafkaTemplate;
    private final  KafkaTemplate<String, Customer> customerKafkaTemplate;

    private final KafkaTemplate<String, User> userKafkaTemplate;
    @Autowired
    public ProducerService(@Qualifier("customerTemplate") KafkaTemplate<String, Customer> kafkaTemplate1,
                           @Qualifier("kafkaTemplate") KafkaTemplate<String, Object> kafkaTemplate2,
                           @Qualifier("userKafkaTemplate") KafkaTemplate<String,User> kafkaTemplate3) {
        this.customerKafkaTemplate = kafkaTemplate1;
        this.kafkaTemplate = kafkaTemplate2;
        this.userKafkaTemplate=kafkaTemplate3;
    }

    public void publishMessageToTopic(String message){
        ListenableFuture<SendResult<String, Object>> future= kafkaTemplate.send(topicName1, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send the message=["+message+"] to topic=["+topicName1+"] with exception="+ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                System.out.println("Sent Message=[" + message + "] with offset=["+
                        result.getRecordMetadata().offset()+"] and " +
                        "partition=["+result.getRecordMetadata().partition()+"]");
            }
        });
    }


    public void publishCustomerMessageToTopic(Customer message){
        ListenableFuture<SendResult<String, Customer>> future= customerKafkaTemplate.send(topicName2, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, Customer>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send the message=["+message+"] to topic=["+topicName2+"] with exception="+ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Customer> result) {
                System.out.println("Sent Message=[" + message + "] with offset=["+
                        result.getRecordMetadata().offset()+"] and " +
                        "partition=["+result.getRecordMetadata().partition()+"]");
            }
        });
    }


    public void publishUserMessageToKafkaTopic(User user){
      ListenableFuture<SendResult<String,User>> userFuture=userKafkaTemplate.send( "MovieBookUsers", 2,"Key123",user);
      userFuture.addCallback(new ListenableFutureCallback<SendResult<String, User>>() {
          @Override
          public void onFailure(Throwable ex) {
              System.out.println("Unable to send the message=["+user+"] to topic=[MovieBookUsers] with exception="+ex.getMessage());
          }

          @Override
          public void onSuccess(SendResult<String, User> result) {
              System.out.println("Sent Message=[" + user + "] with offset=["+
                      result.getRecordMetadata().offset()+"] and " +
                      "partition=["+result.getRecordMetadata().partition()+"]");
          }
      });
    }
}
