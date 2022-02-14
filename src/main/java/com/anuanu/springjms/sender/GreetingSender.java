package com.anuanu.springjms.sender;

import com.anuanu.springjms.config.JmsConfig;
import com.anuanu.springjms.model.GreetingMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class GreetingSender {

    private final JmsTemplate jmsTemplate;
    private static Integer ID = 1;

    @Scheduled(fixedRate = 2000)
    public void sendMessage() {
        System.out.println("Greetings user");
        GreetingMessage message = GreetingMessage
                .builder()
                .id(UUID.randomUUID())
                .message("Greetings user " +  ID++)
                .build();

        jmsTemplate.convertAndSend(JmsConfig.QUEUE, message);
        System.out.println("Message sent!!!");
    }
}
