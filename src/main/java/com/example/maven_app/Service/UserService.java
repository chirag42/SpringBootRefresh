package com.example.maven_app.Service;

import org.springframework.stereotype.Service;

import com.example.maven_app.Model.User;
import com.example.maven_app.Repository.UserRepository;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String name, String email) {
        User user = new User(UUID.randomUUID(), name, email);
        return userRepository.save(user);
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
