package com.example.demo.service;

import com.example.demo.config.AppProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService {

    private static final Logger logger = LoggerFactory.getLogger(EmailNotificationService.class);
    private final AppProperties appProperties;

    public EmailNotificationService(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    public void sendSummaryEmail(String summary) {
        logger.info("Email sent to {} with summary: {}", appProperties.getEmailRecipients(), summary);
    }
}