package com.example.helloworld;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@Slf4j
public class HelloWorldApplication {

    @RestController
    class HelloWorldController {

        @GetMapping("/{name}")
        String hello(@PathVariable String name) {
            log.info("here {}" + name);
            return "Hello " + name + "!";
        }
    }
	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

    private MessageHandler messageHandler;

    @Autowired
    public void setMessageHandler(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }


    @StreamListener(MyChannel.INPUT)
    public void handleMessage(Message<String> message) {
        messageHandler.handleMessage(message);
    }

}
