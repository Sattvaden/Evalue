package com.example.helloworld;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(MyChannel.class)
public class Config {
}
