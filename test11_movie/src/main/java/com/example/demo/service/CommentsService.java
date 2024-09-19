package com.example.demo.service;

import com.example.demo.dto.CommentsDto;
import com.example.demo.dto.PageResultDto;
import com.example.demo.entity.Comments;
import com.example.demo.entity.Movie;
import com.example.demo.repository.CommentsRepository;
import com.example.demo.repository.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CommentsService {
    @Autowired
    CommentsRepository commentsRepository;
    @Autowired
    private MovieRepository movieRepository;

    // dto를 파라미터로 받아서 추가하는 메서드
    public CommentsDto save(CommentsDto dto) {
        Movie m = movieRepository.findById(dto.getMnum()).get();
        Comments comments = dto.toEntity(m);
        Comments c = commentsRepository.save(comments);
        return new CommentsDto(c);
    }

    // 삭제할 댓글번호를 파라미터로 받아서 삭제하는 메서드
    public void delete(Long cnum) {
        commentsRepository.deleteById(cnum);
    }

    // comments list
    public List<Comments> findAll(Long mnum) {
       List<Comments> list = commentsRepository.findByMnum(mnum);
       return list;
    }

    public PageResultDto list(Long mnum, PageRequest pageable) {
        Page<Comments> pagelist = commentsRepository.findByMnum(mnum, pageable);
        List<CommentsDto> clist = pagelist.stream().map(b -> new CommentsDto((b))).toList();
        PageResultDto pageResultDto = new PageResultDto(clist, pagelist.getNumber(), pagelist.getTotalPages(), 5); // 페이지갯수 5개
        return pageResultDto;
    }
}