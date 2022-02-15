package com.anuanu.springjms.listener;

import com.anuanu.springjms.config.JmsConfig;
import com.anuanu.springjms.model.GreetingMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class MessageListener {
    Logger log = LoggerFactory.getLogger(MessageListener.class);
    @JmsListener(destination = JmsConfig.QUEUE)
    public void listen(@Payload GreetingMessage greetingMessage,
                       @Headers MessageHeaders messageHeaders,
                       Message message) {
        log.info("Greeting Received!!!");
        log.info("Greeting message {}", greetingMessage);
        log.info("Message headers {}", messageHeaders);
        log.info("Message {}", message);
    }
}
    