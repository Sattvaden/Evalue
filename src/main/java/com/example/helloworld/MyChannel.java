package com.example.helloworld;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;


public interface MyChannel {

    //this value define binding in application.yaml
    String INPUT = "pubsub";

    @Input(INPUT)
    MessageChannel pubsubadfadf();
}
