package com.example.yin.repository;

import com.example.yin.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Modifying
    @Query("update Comment set up = up + :incr where id = :id")
    int increaseUp(@Param("id") Long id,@Param("incr") int incr);
}
