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
public class PostLike {

    @EmbeddedId
    private PostUserId postLikeId;

    @MapsId("postId")
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @MapsId("userId")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User actor;

    @CreatedDate
    private LocalDateTime createDate;
}
