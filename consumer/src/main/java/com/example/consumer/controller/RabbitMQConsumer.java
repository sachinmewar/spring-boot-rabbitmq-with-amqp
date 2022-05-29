package com.example.consumer.controller;

import com.example.consumer.domain.Animal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Controller;

@Controller
public class RabbitMQConsumer {

    public static Logger logger = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = "${spring.terrestrial.queue.name}")
    public void receiveTerrestrialQueueMessage(Animal terrestrialAnimalMessage) {
        logger.info(".....Inside receiveTerrestrialQueueMessage(Animal terrestrialAnimalMessage) in RabbitMQConsumer..");
        System.out.println("TerrestrialMessage :: " + terrestrialAnimalMessage);
    }

    @RabbitListener(queues = "${spring.aquatic.queue.name}")
    public void receiveAquaticQueueMessage(Animal aquaticAnimalMessage) {
        logger.info(".....Inside receiveAquaticQueueMessage(Animal aquaticAnimalMessage) in RabbitMQConsumer...");
        System.out.println("AquaticQueueMessage :: " + aquaticAnimalMessage);
    }

    @RabbitListener(queues = "${spring.aerial.queue.name}")
    public void receiveAerialQueueMessage(Animal aerialAnimalMessage) {
        logger.info(".....Inside receiveAerialQueueMessage(Animal aerialAnimalMessage) in RabbitMQConsumer..");
        System.out.println("AerialQueueMessage :: " + aerialAnimalMessage);
    }
}