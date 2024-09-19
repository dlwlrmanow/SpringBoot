package com.example.demo.repository;

import com.example.demo.entity.Comments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments, Long> {
    // 영화번호에 해당하는 댓글목록 얻어오기
    @Query("select c from Comments c join c.movie m where m.mnum = :mnum ")
    public List<Comments> findByMnum(@Param("mnum") Long mnum);

    @Query("select c from Comments c join c.movie m where m.mnum = :mnum")
    public Page<Comments> findByMnum(@Param("mnum") Long mnum, PageRequest pageRequest);
}