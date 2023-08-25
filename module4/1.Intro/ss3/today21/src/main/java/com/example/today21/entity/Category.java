package com.example.today21.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "name_category",columnDefinition = "nvarchar(100)")
    private String nameCategory;
    @OneToMany(mappedBy = "category")
    List<Product> products;

    public Category() {
    }

    public Category(int categoryId, String nameCategory, List<Product> products) {
        this.categoryId = categoryId;
        this.nameCategory = nameCategory;
        this.products = products;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
