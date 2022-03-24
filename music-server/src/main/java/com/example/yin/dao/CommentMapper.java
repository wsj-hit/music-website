package com.example.yin.dao;

import com.example.yin.domain.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    int updateCommentMsg(Comment record);

    int deleteComment(Long id);

    List<Comment> allComment();

    List<Comment> commentOfSongId(Long songId);

    List<Comment> commentOfSongListId(Long songListId);
}
