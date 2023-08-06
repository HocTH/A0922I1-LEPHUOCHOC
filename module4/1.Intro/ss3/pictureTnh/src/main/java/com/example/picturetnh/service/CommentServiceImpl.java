package com.example.picturetnh.service;

import com.example.picturetnh.entity.Comment;
import com.example.picturetnh.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository repo;
    @Override
    public boolean save(Comment comment) {
        repo.save(comment);
        return true;
    }

    @Override
    public boolean update(Comment comment) {
        if (repo.existsById(comment.getId())){
            comment.setLikes(comment.getLikes()+1);
            repo.save(comment);
        }
        return false;
    }

    @Override
    public List<Comment> findAll() {
        return (List<Comment>) repo.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        if (repo.existsById(id)){
            repo.deleteById(id);
        }
        return false;
    }

    @Override
    public Comment findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Page<Comment> findAllPaging(Pageable pageable) {
        return repo.findAll(pageable);
    }
}
