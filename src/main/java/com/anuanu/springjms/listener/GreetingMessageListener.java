package com.anuanu.springjms.listener;

import com.anuanu.springjms.config.JmsConfig;
import com.anuanu.springjms.model.GreetingMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class GreetingMessageListener {

    @JmsListener(destination = JmsConfig.QUEUE)
    public void listen(@Payload GreetingMessage greetingMessage,
                       @Headers MessageHeaders messageHeaders,
                       Message message) {
        System.out.println("Greeting Received!!!");
        System.out.println(greetingMessage);
    }
}
