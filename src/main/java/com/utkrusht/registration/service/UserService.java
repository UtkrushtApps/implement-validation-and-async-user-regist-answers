package com.utkrusht.registration.service;

import com.utkrusht.registration.api.model.UserRegistrationRequest;
import com.utkrusht.registration.model.User;
import com.utkrusht.registration.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BackgroundUserSetupService backgroundUserSetupService;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository, BackgroundUserSetupService backgroundUserSetupService) {
        this.userRepository = userRepository;
        this.backgroundUserSetupService = backgroundUserSetupService;
    }

    @Transactional
    public User registerUser(UserRegistrationRequest registrationRequest) {
        // Check for duplicate email
        if (userRepository.existsByEmail(registrationRequest.getEmail())) {
            throw new DuplicateEmailException("A user with this email already exists: " + registrationRequest.getEmail());
        }
        // Hash the password
        String passwordHash = passwordEncoder.encode(registrationRequest.getPassword());
        // Create user entity
        User user = new User(
                registrationRequest.getFirstName(),
                registrationRequest.getLastName(),
                registrationRequest.getEmail(),
                passwordHash
        );
        // Persist user
        User savedUser = userRepository.save(user);
        // Fire off background tasks
        backgroundUserSetupService.runBackgroundSetup(savedUser);
        return savedUser;
    }
}
