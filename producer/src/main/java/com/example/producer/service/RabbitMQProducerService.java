package com.example.producer.service;

import com.example.producer.domain.Animal;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;

@Service
public class RabbitMQProducerService {

    Logger log = Logger.getLogger(RabbitMQProducerService.class.getName());

    @Autowired
    AmqpTemplate rabbitTemplate;

    @Value("${spring.topic-exchange.name}")
    private String exchange;

    public void sendToRabbitMQ(Animal message, String routingKey) {
            rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }
}