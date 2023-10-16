package com.choimax0926.boardbackend.service;

import com.choimax0926.boardbackend.entity.Post;
import com.choimax0926.boardbackend.entity.constant.PostStatus;
import com.choimax0926.boardbackend.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getPosts() {
        List<Post> posts = postRepository.findAllByStatus(PostStatus.ACTIVITY);

        return posts;
    }
}
