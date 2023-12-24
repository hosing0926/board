package com.choimax0926.boardbackend.dto;

import org.springframework.data.domain.Page;

import java.util.List;

public class PageDto<T> {

    private List<T> content;

    private boolean first;

    private boolean last;

    private int page;

    private int size;

    private int totalPage;

    private long totalSize;

    public PageDto(Page pageResult) {
        this.content = pageResult.getContent();
        this.first = pageResult.isFirst();
        this.last = pageResult.isLast();
        this.page = pageResult.getNumber();
        this.size = pageResult.getSize();
        this.totalPage = pageResult.getTotalPages();
        this.totalSize = pageResult.getTotalElements();
    }
}
