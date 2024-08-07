package com.example.yin.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.yin.common.Result;
import com.example.yin.domain.Comment;
import com.example.yin.service.impl.CommentServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@Api(value = "评论")
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentServiceImpl commentService;

    //  提交评论
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object addComment(HttpServletRequest req) {

        JSONObject jsonObject = new JSONObject();
        String user_id = req.getParameter("userId");
        String type = req.getParameter("type");
        String song_list_id = req.getParameter("songListId");
        String song_id = req.getParameter("songId");
        String content = req.getParameter("content").trim();

        Comment comment = new Comment();
        comment.setUserId(Long.parseLong(user_id));
        comment.setType(new Byte(type));
        if (new Byte(type) == 0) {
            comment.setSongId(Long.parseLong(song_id));
        } else if (new Byte(type) == 1) {
            comment.setSongListId(Long.parseLong(song_list_id));
        }
        comment.setContent(content);
        comment.setCreateTime(new Date());
        boolean res = commentService.addComment(comment);
        if (res) {
            jsonObject.put("code", 1);
            jsonObject.put("msg", "评论成功");
            return jsonObject;
        } else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "评论失败");
            return jsonObject;
        }
    }

    //    获取所有评论列表
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Object allComment() {
        return commentService.allComment();
    }

    //    获得指定歌曲ID的评论列表
    @RequestMapping(value = "/song/detail", method = RequestMethod.GET)
    public Object commentOfSongId(HttpServletRequest req) {
        String songId = req.getParameter("songId");
        return commentService.commentOfSongId(Long.parseLong(songId));
    }

    //    获得指定歌单ID的评论列表
    @RequestMapping(value = "/songList/detail", method = RequestMethod.GET)
    public Object commentOfSongListId(HttpServletRequest req) {
        String songListId = req.getParameter("songListId");
        return commentService.commentOfSongListId(Long.parseLong(songListId));
    }

    //    点赞
    @ResponseBody
    @RequestMapping(value = "/like", method = RequestMethod.POST)
    @ApiOperation(value = "点赞")
    public Result<?> commentOfLike(Long id) {
        commentService.thumbUp(id);
        return Result.success();
    }

    //    删除评论
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Object deleteComment(HttpServletRequest req) {
        String id = req.getParameter("id");
        return commentService.deleteComment(Long.parseLong(id));
    }

    //    更新评论
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Object updateCommentMsg(HttpServletRequest req) {
        JSONObject jsonObject = new JSONObject();
        String id = req.getParameter("id").trim();
        String user_id = req.getParameter("userId").trim();
        String song_id = req.getParameter("songId").trim();
        String song_list_id = req.getParameter("songListId").trim();
        String content = req.getParameter("content").trim();
        String type = req.getParameter("type").trim();
        String up = req.getParameter("up").trim();

        Comment comment = new Comment();
        comment.setId(Long.parseLong(id));
        comment.setUserId(Long.parseLong(user_id));
        if (song_id == "") {
            comment.setSongId(null);
        } else {
            comment.setSongId(Long.parseLong(song_id));
        }

        if (song_list_id == "") {
            comment.setSongListId(null);
        } else {
            comment.setSongListId(Long.parseLong(song_list_id));
        }
        comment.setContent(content);
        comment.setType(new Byte(type));
        comment.setUp(Long.parseLong(up));

        boolean res = commentService.updateCommentMsg(comment);
        if (res) {
            jsonObject.put("code", 1);
            jsonObject.put("msg", "修改成功");
            return jsonObject;
        } else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "修改失败");
            return jsonObject;
        }
    }
}
