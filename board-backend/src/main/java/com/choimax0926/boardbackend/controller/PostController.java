package com.choimax0926.boardbackend.controller;

import com.choimax0926.boardbackend.dto.PageDto;
import com.choimax0926.boardbackend.entity.Post;
import com.choimax0926.boardbackend.request.PostRequest;
import com.choimax0926.boardbackend.response.ApiResponse;
import com.choimax0926.boardbackend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/post")
@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @GetMapping
    public ApiResponse getPosts(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Long userId = 1L;
        PageDto<Post> posts = postService.getPosts(page, size);

        return ApiResponse.builder()
                .data(posts)
                .build();
    }

    @PostMapping
    public ApiResponse createPost(
            @RequestPart(required = false) PostRequest request
    ) {
        Long userId = 1L;
        Post post = postService.createPost(userId, request);

        return ApiResponse.builder()
                .data(post)
                .build();
    }
}
