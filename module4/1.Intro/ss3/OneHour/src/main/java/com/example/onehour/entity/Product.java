package com.example.onehour.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
public class Product {
    @Id
    private int id;
    @NotBlank(message = "Khong de trong ")
    @Pattern(regexp = "^[a-zA-z]{1,3}")
    private String name;
    @Min(1)
    private int quantity;
    @Min(1)
    private int price;
    @Email
    private String email;
    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "category_id")
    private Category category;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateRelease;

    public Product() {
    }

    public Product(int id, String name, int quantity, int price, String email, Category category, Date dateRelease) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.email = email;
        this.category = category;
        this.dateRelease = dateRelease;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(Date dateRelease) {
        this.dateRelease = dateRelease;
    }
}
