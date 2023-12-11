package com.example.boking.service;

import com.example.boking.controller.RegisterRequest;
import com.example.boking.exception.ExceptionUtils;
import com.example.boking.model.User;
import com.example.boking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    @Override
    public User create(RegisterRequest request, String keycloakId) {
        User user = newUser(request);
        user.setKeycloakId(keycloakId);
        return userRepository.save(user);
    }

    @Override
    public User getByUsername(String username) {
        Optional<User> user = userRepository.findByEmail(username);
        return user.orElseThrow(() -> ExceptionUtils.notFound("User not found by username: %s", username));
    }

    @Override
    public User getById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> ExceptionUtils.notFound("User not found by id: %s", id));
    }

    @Override
    public User getByKeycloakId(String keycloakId) {
        Optional<User> user = userRepository.findByKeycloakId(keycloakId);
        return user.orElseThrow(() -> ExceptionUtils.notFound("User not found by keycloakId: %s", keycloakId));
    }


    private User newUser(UserRepository request) {
        User user = new User();
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());
        return user;
    }

}
