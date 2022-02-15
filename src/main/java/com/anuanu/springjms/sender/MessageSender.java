package com.anuanu.springjms.sender;

import com.anuanu.springjms.config.JmsConfig;
import com.anuanu.springjms.listener.MessageListener;
import com.anuanu.springjms.model.GreetingMessage;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class MessageSender {

    Logger log = LoggerFactory.getLogger(MessageSender.class);
    private final JmsTemplate jmsTemplate;
    private static Integer ID = 1;

    @Scheduled(fixedRate = 2000)
    public void sendMessage() {
        log.info("Greetings user");
        GreetingMessage message = GreetingMessage
                .builder()
                .id(UUID.randomUUID())
                .message("Greetings user " +  ID++)
                .build();

        jmsTemplate.convertAndSend(JmsConfig.QUEUE, message);
        log.info("Message sent!!!");
    }
}
