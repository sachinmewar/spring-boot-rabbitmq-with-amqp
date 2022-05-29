package com.example.producer.controller;

import com.example.producer.domain.Animal;
import com.example.producer.service.RabbitMQProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/publisher/")
public class RabbitMQWebController {

    @Autowired
    private RabbitMQProducerService rabbitmqService;

    @PostMapping(value = "/terrestrial")
    public String terrestrial(@RequestParam(name = "routing-key") String routingKey,
            @RequestBody Animal terrestrialAnimal) {
        terrestrialAnimal.setId(UUID.randomUUID().toString());
        rabbitmqService.sendToRabbitMQ(terrestrialAnimal, routingKey);
        return "Message sent to terrestrial queue Successfully";
    }

    @PostMapping(value = "/aquatic")
    public String aquatic(@RequestParam(name = "routing-key") String routingKey,
                         @RequestBody Animal aquaticAnimal) {
        aquaticAnimal.setId(UUID.randomUUID().toString());
        rabbitmqService.sendToRabbitMQ(aquaticAnimal, routingKey);
        return "Message sent to aquatic queue Successfully";
    }

    @PostMapping(value = "/aerial")
    public String aerial(@RequestParam(name = "routing-key") String routingKey,
                                 @RequestBody Animal aerialAnimal) {
        aerialAnimal.setId(UUID.randomUUID().toString());
        rabbitmqService.sendToRabbitMQ(aerialAnimal, routingKey);
        return "Message sent to aerial queue Successfully";
    }
}
