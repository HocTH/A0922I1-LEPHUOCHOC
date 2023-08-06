package codegym.vn.validate;

import codegym.vn.entity.Product;
import codegym.vn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProductValidate implements Validator {
    @Autowired
    ProductService productService;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!(target instanceof Product)) {
            return;
        }

        Product product = (Product) target;
        if (productService.findById(product.getId()) != null) {
            errors.rejectValue("id", "Duplicate",
                    null, "ID bị trùng lặp");
        }
    }
}
