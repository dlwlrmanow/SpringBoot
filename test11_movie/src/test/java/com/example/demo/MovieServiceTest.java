package com.example.demo;

import com.example.demo.dto.MovieDto;
import com.example.demo.entity.Comments;
import com.example.demo.entity.Movie;
import com.example.demo.repository.MovieRepository;
import com.example.demo.service.MovieService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
@Transactional
//@Rollback(value = false)
@Commit
public class MovieServiceTest {
    @Autowired
    MovieService service;


    @Test
    void save(){
        service.save(new MovieDto(0L, "movie01", "content01", "director01"));
        service.save(new MovieDto(0L, "movie02", "content02", "director02"));
        service.save(new MovieDto(0L, "movie03", "content03", "director03"));
    }

    @Test
    void selet(){
        MovieDto movie = service.select(1L);
        System.out.println(movie);
    }

    @Test
    void findAll() {
        List<MovieDto> mlist = service.movieList();
        mlist.forEach(dto -> {
            System.out.println(dto);
        });
    }


}
