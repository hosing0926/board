package com.choimax0926.boardbackend.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class PostRequest {

    private Long id;

    private String title;

    private String content;

    private List<MultipartFile> images;
}
