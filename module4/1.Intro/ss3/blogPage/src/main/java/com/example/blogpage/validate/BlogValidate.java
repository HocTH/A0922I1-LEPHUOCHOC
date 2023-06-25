package com.example.blogpage.validate;

import com.example.blogpage.entity.Blog;
import com.example.blogpage.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.ConstraintViolation;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;
import java.util.Set;

public class BlogValidate implements Validator {
    @Autowired
    BlogService blogService;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!(target instanceof Blog)){
            return;
        }
        Blog blog = (Blog) target;
        if(blogService.findById(blog.getId())!= null){
            errors.rejectValue("id", "Duplicate",null,"Name bị lặp");
        }
    }
}
