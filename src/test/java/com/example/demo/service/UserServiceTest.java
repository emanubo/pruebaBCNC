package com.example.demo.service;

import com.example.demo.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class UserServiceTest {
    @Mock
    private WebClient.Builder webClientBuilder; // Mock de WebClient.Builder

    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Configura el WebClient.Builder simulado para que devuelva un WebClient vacío
        WebClient webClient = WebClient.builder().baseUrl("https://jsonplaceholder.typicode.com").build();
        when(webClientBuilder.baseUrl("https://jsonplaceholder.typicode.com")).thenReturn(webClientBuilder);
        when(webClientBuilder.build()).thenReturn(webClient);

        userService = new UserService(webClientBuilder);
    }

    @Test
    void testGetUsers() throws ExecutionException, InterruptedException {
        int userId = 1;
        User user = new User(1, "Leanne Graham", "Bret", "Sincere@april.biz");
        CompletableFuture<User> userFuture = CompletableFuture.completedFuture(user);
        CompletableFuture<Map<String, Object>> resultFuture = userService.getUserWithAlbumsAndPosts(userId);
        Map<String, Object> result = resultFuture.get();
        assertEquals(user, result.get("user"));

    }
}