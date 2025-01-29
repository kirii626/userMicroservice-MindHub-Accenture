package com.mindhub.user_microservice.publishers;

import com.mindhub.user_microservice.dtos.UserDtoOutput;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserRegisteredPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingkey.user}")
    private String userRoutingKey;

    public void sendUserRegisteredEvent(UserDtoOutput userDtoOutput) {
        rabbitTemplate.convertAndSend(exchange, userRoutingKey, userDtoOutput);
    }
}
