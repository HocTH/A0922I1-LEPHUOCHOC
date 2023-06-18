package com.example.nasa.service;

import com.example.nasa.entity.Comment;
import com.example.nasa.repo.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class CommentServiceImpl implements CommentService{
   @Autowired
   private CommentRepository repository;
    @Override
    public boolean create(Comment comment) {
        comment.setDate();
        repository.save(comment);
        return true ;
    }

    @Override
    public boolean update(Comment comment) {
        if (repository.existsById(comment.getId())){
            comment.setLikes(comment.getLikes()+1);
            repository.save(comment);
        }
        return false;
    }

    @Override
    public List<Comment> findAll() {
        return (List<Comment>) repository.findAll();
    }

    @Override
    public Comment findById(int id) {
        return repository.findById(id).orElse(null);
    }
}
