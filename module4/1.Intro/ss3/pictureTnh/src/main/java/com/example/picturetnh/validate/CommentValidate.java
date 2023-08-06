package com.example.picturetnh.validate;

import com.example.picturetnh.entity.Comment;
import com.example.picturetnh.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class CommentValidate implements Validator {
    @Autowired
    private CommentService commentService;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!(target instanceof Comment)){
            return;
        }
        Comment comment = (Comment) target;
    }
}
