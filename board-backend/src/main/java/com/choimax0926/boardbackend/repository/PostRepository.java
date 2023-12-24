package com.choimax0926.boardbackend.repository;

import com.choimax0926.boardbackend.entity.Post;
import com.choimax0926.boardbackend.entity.constant.PostStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

    @Query("SELECT p FROM Post p WHERE p.status =:status")
    Page<Post> findAllByStatus(PostStatus status, PageRequest pageRequest);
}
