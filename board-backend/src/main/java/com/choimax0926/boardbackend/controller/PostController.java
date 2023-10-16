package com.choimax0926.boardbackend.controller;

import com.choimax0926.boardbackend.entity.Post;
import com.choimax0926.boardbackend.response.ApiResponse;
import com.choimax0926.boardbackend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/post")
@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @GetMapping
    public ApiResponse getPosts() {
        List<Post> posts = postService.getPosts();

        return ApiResponse.builder()
                .data(posts)
                .build();
    }
}
