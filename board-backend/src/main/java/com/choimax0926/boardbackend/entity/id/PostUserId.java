package com.choimax0926.boardbackend.entity.id;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PostUserId implements Serializable {

    private Long postId;

    private Long userId;
}
