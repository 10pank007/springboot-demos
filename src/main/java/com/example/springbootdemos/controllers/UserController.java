package com.example.springbootdemos.controllers;

import com.example.springbootdemos.models.User;
import com.example.springbootdemos.services.MainService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
    private MainService mainService;

    @PostMapping("/users")
    public void saveUser(@RequestBody User user) {
        mainService.send(user.getEmail());
    }
}
