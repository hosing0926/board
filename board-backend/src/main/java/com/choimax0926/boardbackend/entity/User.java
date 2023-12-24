package com.choimax0926.boardbackend.entity;

import com.choimax0926.boardbackend.entity.constant.Date;
import com.choimax0926.boardbackend.entity.constant.LoginType;
import com.choimax0926.boardbackend.entity.constant.UserStatus;
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
public class User extends Date {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LoginType type;

    private String email;

    private String password;

    private String nickname;

    private int imageCount;

    private UserStatus status;
}