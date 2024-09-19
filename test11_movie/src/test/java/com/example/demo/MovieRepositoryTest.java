package com.example.demo;

import com.example.demo.entity.Comments;
import com.example.demo.entity.Movie;
import com.example.demo.repository.CommentsRepository;
import com.example.demo.repository.MovieRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Commit;

import java.util.List;

@SpringBootTest
@Transactional
@Commit
public class MovieRepositoryTest {
    @Autowired
    MovieRepository mrepository;
    @Autowired
    CommentsRepository crepository;

    @Test
    void findById() {
        List<Movie> list = mrepository.findAll();
        PageRequest pageRequest = PageRequest.of(1, 5);
        list.forEach(m->{
            System.out.println(m.getMnum() + ", " + m.getTitle() + ", " + m.getContent() + ", " + m.getDirector());
            System.out.println("<<  댓글  >>");
            Page<Comments> clist  = crepository.findByMnum(m.getMnum(), pageRequest);
            clist.forEach(c ->{
                System.out.println(c.getCnum() + ", " + c.getId() + ", " + c.getComments());
            });
            System.out.println("-------------------------------------");
        });
    }
}
