package com.example.nasa.service;

import com.example.nasa.entity.Comment;

import java.util.List;

public interface CommentService {
    boolean create (Comment comment);
    boolean update(Comment comment);
    List<Comment> findAll();
    Comment findById(int id);
}
