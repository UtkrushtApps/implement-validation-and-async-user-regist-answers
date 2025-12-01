package com.utkrusht.registration.api.controller;

import com.utkrusht.registration.api.model.UserRegistrationRequest;
import com.utkrusht.registration.api.model.UserRegistrationResponse;
import com.utkrusht.registration.model.User;
import com.utkrusht.registration.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
@Validated
public class UserRegistrationController {
    private static final Logger logger = LoggerFactory.getLogger(UserRegistrationController.class);

    private final UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegistrationResponse> register(@Valid @RequestBody UserRegistrationRequest request) {
        logger.info("Attempting registration for {}", request.getEmail());
        User user = userService.registerUser(request);
        logger.info("Registration successful for {}", user.getEmail());
        UserRegistrationResponse response = new UserRegistrationResponse(
                user.getId(), user.getEmail(), "registered"
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
