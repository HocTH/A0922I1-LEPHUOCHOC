package com.example.validate.repo;

import com.example.validate.model.Form;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FormRepository extends PagingAndSortingRepository<Form, Integer> {
}
