package com.example.demo.controller;

import com.example.demo.service.MyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyControllerTest {

    @InjectMocks
    private MyController myController;

    @Mock
    private MyService myService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetUserWithAlbumsAndPosts() throws ExecutionException, InterruptedException {
        int userId = 1;
        Map<String, Object> userData = new HashMap<>();
        userData.put("id", userId);
        userData.put("name", "John Doe");
        userData.put("albums", 3);
        userData.put("posts", 5);

        CompletableFuture<Map<String, Object>> userWithAlbumsAndPosts = CompletableFuture.completedFuture(userData);

        Mockito.when(myService.getUserWithAlbumsAndPosts(userId)).thenReturn(userWithAlbumsAndPosts);

        CompletableFuture<Map<String, Object>> result = myController.getUserWithAlbumsAndPosts(userId);

        // Verifica que el resultado del controlador coincida con el valor simulado por el servicio
        assertEquals(userWithAlbumsAndPosts.get(), result.get());
    }
}