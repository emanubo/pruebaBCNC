package com.example.demo.controller;

import com.example.demo.service.MyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
public class MyController {
    private final MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/users/{id}")
    public CompletableFuture<Map<String, Object>> getUserWithAlbumsAndPosts(@PathVariable int id) {
        return myService.getUserWithAlbumsAndPosts(id);
    }
}

