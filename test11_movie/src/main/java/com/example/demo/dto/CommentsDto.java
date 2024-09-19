package com.example.demo.dto;

import com.example.demo.entity.Comments;
import com.example.demo.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentsDto {
    private Long cnum;
    private Long mnum;
    private String id;
    private String comments;

    public CommentsDto(Comments comments) {
        this.cnum = comments.getCnum();
        this.mnum = comments.getMovie().getMnum();
        this.id = comments.getId();
        this.comments = comments.getComments();
    }

    public Comments toEntity(Movie movie){
        Comments comments = Comments.builder()
                .cnum(this.cnum)
                .movie(movie)
                .id(this.id)
                .comments(this.comments)
                .build();
        return comments;
    }
}
