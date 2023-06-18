package com.example.comment.service;

import com.example.comment.entity.Comment;

import java.util.List;

public interface CommentService {
    boolean create (Comment comment);
    boolean update(Comment comment);
    List<Comment> findAll();
}
