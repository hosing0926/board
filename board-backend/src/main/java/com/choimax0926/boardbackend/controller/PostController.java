package com.choimax0926.boardbackend.controller;

import com.choimax0926.boardbackend.entity.Post;
import com.choimax0926.boardbackend.entity.PostLike;
import com.choimax0926.boardbackend.exception.ApiException;
import com.choimax0926.boardbackend.exception.Error;
import com.choimax0926.boardbackend.response.ApiResponse;
import com.choimax0926.boardbackend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/post")
@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @GetMapping
    public ApiResponse getPosts() {
        List<Post> posts = postService.getPosts();

        if (posts.size() == 0) {
            Post post = Post.builder()
                    .postId(1L)
                    .title("title test")
                    .content("const test")
                    .likes(Arrays.asList(new PostLike()))
                    .createDate(LocalDateTime.now()).build();

            posts = Arrays.asList(post,post,post,post,post,post,post,post,post);
        }

        return ApiResponse.builder()
                .data(posts)
                .build();
    }
}
