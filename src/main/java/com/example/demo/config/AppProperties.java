package com.example.demo.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "transaction")
public class AppProperties {

    @lombok.Setter
    private double dailyLimit;
    @lombok.Setter
    @Getter
    private List<String> emailRecipients;

}