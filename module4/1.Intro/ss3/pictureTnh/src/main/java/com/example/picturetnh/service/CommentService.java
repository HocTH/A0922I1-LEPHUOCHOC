package com.example.picturetnh.service;

import com.example.picturetnh.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {
    boolean save(Comment comment);
    boolean update(Comment comment);
    List<Comment> findAll();
    boolean deleteById(int id);
    Comment findById(int id);
    Page<Comment> findAllPaging(Pageable pageable);
}
