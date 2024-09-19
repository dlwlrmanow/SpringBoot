package com.example.demo.service;

import com.example.demo.dto.MovieDto;
import com.example.demo.entity.Movie;
import com.example.demo.repository.MovieRepository;
import jakarta.transaction.Transactional;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MovieService {
    @Autowired MovieRepository movieRepository;

    public MovieDto save(MovieDto dto) {
        Movie movie = dto.toEntity();
        return new MovieDto(movieRepository.save(movie));
    }

    public MovieDto select(long mnum){
        Movie movie = movieRepository.findById(mnum).get();
        return new MovieDto(movie);
    }

    public List<MovieDto> movieList(){
        List<Movie> mlist = movieRepository.findAll();
        return mlist.stream().map(t -> new MovieDto(t)).toList(); // return MovieDto로 반환
    }
}
