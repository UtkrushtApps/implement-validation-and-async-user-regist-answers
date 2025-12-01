package com.utkrusht.registration.service;

import com.utkrusht.registration.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class BackgroundUserSetupService {
    private static final Logger logger = LoggerFactory.getLogger(BackgroundUserSetupService.class);

    @Async
    public void runBackgroundSetup(User user) {
        try {
            logger.info("Running background setup for user: {}", user.getEmail());
            // Simulated background profile setup task (e.g., sending welcome email, provisioning)
            Thread.sleep(1500); // simulate work
            logger.info("Completed background setup for user: {}", user.getEmail());
        } catch (InterruptedException ex) {
            logger.warn("Background setup interrupted for user: {}", user.getEmail());
            Thread.currentThread().interrupt();
        }
    }
}
