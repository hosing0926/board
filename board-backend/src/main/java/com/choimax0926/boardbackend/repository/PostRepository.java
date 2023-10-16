package com.choimax0926.boardbackend.repository;

import com.choimax0926.boardbackend.entity.Post;
import com.choimax0926.boardbackend.entity.constant.PostStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findAllByStatus(PostStatus status);
}
