package com.choimax0926.boardbackend.entity;

import com.choimax0926.boardbackend.entity.id.PostUserId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class PostReport {

    @EmbeddedId
    private PostUserId postLikeId;

    @MapsId("postId")
    @ManyToOne
    private Post post;

    @MapsId("userId")
    @ManyToOne
    private User user;

    @CreatedDate
    private LocalDateTime createDate;
}
