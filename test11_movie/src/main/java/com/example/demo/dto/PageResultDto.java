package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageResultDto {
    private List<CommentsDto> list;
    private int startPage;
    private int endPage;
    private int totalPageCount;
    private int page;

    public PageResultDto(List<CommentsDto> list, int page, int totalPageCount, int blockLimit) {
        this.list = list;
        this.page = page;
        this.totalPageCount = totalPageCount;
        startPage = (page/blockLimit)*blockLimit;
        endPage = Math.min(startPage + blockLimit -1, totalPageCount-1);
        if (totalPageCount ==0) endPage = 0;
    }
}