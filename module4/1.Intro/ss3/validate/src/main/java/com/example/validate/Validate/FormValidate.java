package com.example.validate.Validate;

import com.example.validate.model.Form;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
public class FormValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!(target instanceof Form)){
            return;
        }
        Form form = (Form) target;
        String phoneNumber = form.getPhoneNumber();
        ValidationUtils.rejectIfEmpty(errors,"phoneNumber","phoneNumber.empty",null,"empty number");
        if (phoneNumber.length()>11 || phoneNumber.length()<10){
            errors.rejectValue("phoneNumber", "phoneNumber.length",null," wrong number");
        } else if (!phoneNumber.startsWith("0")){
            errors.rejectValue("phoneNumber", "phoneNumber.startsWith",null," wrong number");
        }else if (!phoneNumber.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phoneNumber", "phoneNumber.matches",null," wrong number");
        }
    }
}
