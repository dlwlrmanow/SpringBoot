package com.example.demo.dto;

import com.example.demo.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieDto {
    // Movie 멤버변수값
    private Long mnum;
    private String title;
    private String content;
    private String director;

    // 생성자에서 Movie객체 받아와서 Dto로 변환
    public MovieDto(Movie movie) {
        this.mnum = movie.getMnum();
        this.title = movie.getTitle();
        this.content = movie.getContent();
        this.director = movie.getDirector();
    }

    // dto => entity로 변환
    public Movie toEntity() {
        Movie movie = Movie.builder()
                .mnum(this.mnum)
                .title(this.title)
                .content(this.content)
                .director(this.director)
                .build();
        return movie;
    }
}
