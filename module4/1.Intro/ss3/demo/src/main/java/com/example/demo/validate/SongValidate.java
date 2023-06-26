package com.example.demo.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SongValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
    @Override
    public void validate(Object target, Errors errors) {

    }
}
