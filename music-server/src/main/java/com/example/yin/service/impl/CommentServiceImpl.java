package com.example.yin.service.impl;

import com.example.yin.dao.CommentMapper;
import com.example.yin.repository.CommentRepository;
import com.example.yin.domain.Comment;
import com.example.yin.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentMapper commentMapper, CommentRepository commentRepository) {
        this.commentMapper = commentMapper;
        this.commentRepository = commentRepository;
    }

    @Override
    public boolean addComment(Comment comment) {
        return commentMapper.insertSelective(comment) > 0 ? true : false;
    }

    @Override
    public boolean updateCommentMsg(Comment comment) {
        return commentMapper.updateCommentMsg(comment) > 0;
    }

    //    删除评论
    @Override
    public boolean deleteComment(Long id) {
        return commentMapper.deleteComment(id) > 0;
    }

    @Override
    public List<Comment> allComment() {
        return commentMapper.allComment();
    }

    @Override
    public List<Comment> commentOfSongId(Long songId) {
        return commentMapper.commentOfSongId(songId);
    }

    @Override
    public List<Comment> commentOfSongListId(Long songListId) {
        return commentMapper.commentOfSongListId(songListId);
    }

    @Override
//    @Transactional
    public void thumbUp(Long id) {
//        Comment comment = commentRepository.getById(id);
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new RuntimeException("no comment founded"));
        comment.setUp(comment.getUp() + 1);
        // 自动更新
//        commentRepository.save(comment);
    }
}
