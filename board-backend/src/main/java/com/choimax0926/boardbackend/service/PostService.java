package com.choimax0926.boardbackend.service;

import com.choimax0926.boardbackend.dto.PageDto;
import com.choimax0926.boardbackend.entity.Post;
import com.choimax0926.boardbackend.entity.constant.PostStatus;
import com.choimax0926.boardbackend.repository.PostRepository;
import com.choimax0926.boardbackend.request.PostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public PageDto<Post> getPosts(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id"));
        Page<Post> posts = postRepository.findAllByStatus(PostStatus.POSTED, pageRequest);

        return new PageDto(posts);
    }

    public Post createPost(Long userId, PostRequest request) {
        return null;
    }
}
