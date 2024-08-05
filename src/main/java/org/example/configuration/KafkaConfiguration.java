package org.example.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.example.dao.Customer;
import org.example.dao.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;

import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConfiguration {

    @Bean
    public NewTopic topicCreation(){
        System.out.println("Creating new kafka topic");
        return new NewTopic("BSMD",3,(short) 1);
    }

    @Bean
    public NewTopic userTopicCreation(){
        System.out.println("Creating new kafka topic");
        return new NewTopic("MovieBookUsers",3,(short) 1);
    }

    @Bean(name="consumerFactory")
    public ConsumerFactory<String, Object> consumerFactory(){
        Map<String,Object> map=new HashMap<>();
        map.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        map.put(ConsumerConfig.GROUP_ID_CONFIG, "my-consumer-group-2");
        map.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        map.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        map.put(JsonDeserializer.TRUSTED_PACKAGES, "com.example.dao");

        return new DefaultKafkaConsumerFactory<>(map);
    }

    @Bean(name="customerConsumer")
    @DependsOn("consumerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, Object> concurrentKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String,Object> factory=new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(5);
        //factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
        return factory;
    }

    @Bean(name="customerProducer")
    public ProducerFactory<String, Customer> producerFactory(){
        Map<String, Object> props=new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new  DefaultKafkaProducerFactory(props);
    }

    @Bean(name="customerTemplate")
    @DependsOn("customerProducer")
    public KafkaTemplate<String, Customer> customerKafkaTemplate(){
        System.out.println("Customer Kafka Template Created");
        return new KafkaTemplate<String,Customer>(producerFactory());
    }

    @Bean(name="stringProducer")
    public ProducerFactory<String, Object> producerFactory1(){
        Map<String, Object> props=new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new  DefaultKafkaProducerFactory(props);
    }

    @Bean(name="kafkaTemplate")
    @DependsOn("stringProducer")
    public KafkaTemplate<String, Object> KafkaTemplate(){

        return new KafkaTemplate<String, Object>(producerFactory1());
    }


    @Bean(name = "userProducer")
    public ProducerFactory<String, User> userProducerFactory(){
        Map<String,Object> map=new HashMap<>();
        map.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        map.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        map.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory(map);
    }

    @Bean(name="userKafkaTemplate")
    @DependsOn("userProducer")
    public KafkaTemplate<String, User> kafkaTemplateUser(){
        return new KafkaTemplate<>(userProducerFactory());
    }

    @Bean(name = "userConsumer")
    public ConsumerFactory<String, User> userConsumerFactory(){
        Map<String,Object> map=new HashMap<>();
        map.put(ConsumerConfig.GROUP_ID_CONFIG,"my-consumer-group4");
        map.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        map.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        map.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        map.put(JsonDeserializer.TRUSTED_PACKAGES, "org.example.dao");

        return new DefaultKafkaConsumerFactory<>(map);
    }

    @Bean(name="userContainerFactory")
    @DependsOn("userConsumer")
    public ConcurrentKafkaListenerContainerFactory<String, User> userConcurrentKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String,User> userConcurrentKafkaListenerContainerFactory
                =new ConcurrentKafkaListenerContainerFactory<>();
        userConcurrentKafkaListenerContainerFactory.setConsumerFactory(userConsumerFactory());
        userConcurrentKafkaListenerContainerFactory.setConcurrency(5);

        return  userConcurrentKafkaListenerContainerFactory;
    }



    @Bean
    public NewTopic deadLetterTopic() {
        return new NewTopic("your-topic.dlt", 1, (short) 1);
    }

}
