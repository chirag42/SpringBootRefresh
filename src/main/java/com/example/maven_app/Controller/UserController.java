package com.example.maven_app.Controller;

import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;
import java.util.stream.*;

import org.springframework.web.bind.annotation.*;

import com.example.maven_app.Model.User;
import com.example.maven_app.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestParam String name, @RequestParam String email) {
        return userService.createUser(name, email);
    }

//    @GetMapping
//    public Iterable<User> getAllUsers() {
//        return userService.getAllUsers();
//    }
    
    @GetMapping
    public List<Map<String, String>> getAllUsers() {
        return StreamSupport.stream(userService.getAllUsers().spliterator(), false)
                .map(user -> Map.of("name", user.getName(), "email", user.getEmail()))
                .collect(Collectors.toList());
    }
 
}
