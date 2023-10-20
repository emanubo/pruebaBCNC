package com.example.demo.service;

import com.example.demo.model.Album;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
@Service
public class MyService {
    private final WebClient webClient;

    public MyService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://jsonplaceholder.typicode.com").build();
    }

    public CompletableFuture<Map<String, Object>> getUserWithAlbumsAndPosts(int id) {
        CompletableFuture<User> userFuture = webClient.get()
                .uri("https://jsonplaceholder.typicode.com/users/{id}", id)
                .retrieve()
                .bodyToMono(User.class)
                .toFuture();

        CompletableFuture<List<Album>> albumFuture = webClient.get()
                .uri("https://jsonplaceholder.typicode.com/albums?userId={id}", id)
                .retrieve()
                .bodyToFlux(Album.class)
                .collectList()
                .toFuture();

        CompletableFuture<List<Post>> postFuture = webClient.get()
                .uri("https://jsonplaceholder.typicode.com/posts?userId={id}", id)
                .retrieve()
                .bodyToFlux(Post.class)
                .collectList()
                .toFuture();

        return CompletableFuture.allOf(userFuture, albumFuture, postFuture)
                .thenApplyAsync(unused -> {
                    Map<String, Object> result = new HashMap<>();
                    result.put("user", userFuture.join());
                    result.put("albums", albumFuture.join());
                    result.put("posts", postFuture.join());
                    return result;
                });
    }
}