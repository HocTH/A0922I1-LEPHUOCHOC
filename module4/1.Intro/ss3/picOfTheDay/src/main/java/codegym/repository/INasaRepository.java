package codegym.service;

import codegym.model.Comment;

import java.util.List;

public interface INasaRepository {
    void create(Comment comment);
    List<Comment> findAll();
    List<Comment> findAllToday(String date);
}
