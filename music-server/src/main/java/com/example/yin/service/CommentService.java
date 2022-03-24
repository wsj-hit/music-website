package com.example.yin.service;

import com.example.yin.domain.Comment;

import java.util.List;

public interface CommentService {

    boolean addComment(Comment comment);

    boolean updateCommentMsg(Comment comment);

    boolean deleteComment(Long id);

    List<Comment> allComment();

    List<Comment> commentOfSongId(Long songId);

    List<Comment> commentOfSongListId(Long songListId);

    void thumbUp(Long id);
}
