package com.example.helloworld;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageHandler {


    public void handleMessage(Message<String> message) {
        log.info("Received: " + message.getPayload());
    }
}
