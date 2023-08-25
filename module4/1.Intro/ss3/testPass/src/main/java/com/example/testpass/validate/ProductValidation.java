package com.example.testpass.validate;

import com.example.testpass.entity.Product;
import com.example.testpass.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class ProductValidation implements Validator {
    @Autowired
    private ProductService productService;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!(target instanceof Product)){
            return;
        }
        Product product = (Product) target;
        String[] banWord = {"dm","com me may"};
        for (String ban:banWord) {
            if (product.getName().contains(ban)){
                errors.rejectValue("name","Spam",null,"Spam name");
                break;
            }
        }
    }
}
