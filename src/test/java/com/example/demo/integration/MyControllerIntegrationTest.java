package com.example.demo.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MyControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetUserWithAlbumsAndPosts() {
        int userId = 1; // Replace with the user ID you want to test

        Map<String, Object> result = restTemplate.getForObject("/users/{id}", Map.class, userId);

        assertNotNull(result);
        assertNotNull(result.get("user"));
        assertNotNull(result.get("albums"));
        assertNotNull(result.get("posts"));
    }

}




