package com.example.demo.config;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingConfig {

    @Getter
    private static final Logger serviceLogger = LoggerFactory.getLogger("ServiceLogger");
    @Getter
    private static final Logger controllerLogger = LoggerFactory.getLogger("ControllerLogger");

}