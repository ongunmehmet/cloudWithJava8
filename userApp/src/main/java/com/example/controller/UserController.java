package com.example.controller;


import com.example.dto.PurchaseDto;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/user")
@EnableCaching
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/get")
    public User getUser(@RequestParam long id) {
        return userService.findById(id);
    }

    @GetMapping("/getAll")
    public List<User> getUser() {
        return userService.findAll();
    }

    @PostMapping("/purchaseBook")
    public void buyRequest(@RequestBody PurchaseDto purchaseDto) {
        userService.buyBook(purchaseDto);
    }
}
