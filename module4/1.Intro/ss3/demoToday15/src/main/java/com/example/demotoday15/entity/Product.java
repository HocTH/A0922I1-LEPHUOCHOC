package com.example.demotoday15.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.util.Date;

@Entity
public class Product {
    @Id
    private int id;
    @NotBlank(message = "Name không được để trống")
    @Column(columnDefinition = "nvarchar(100)")
    private String name;
    @Min(1) @Max(100)
    private int quantity;
    @Min(1) @Max(100000000)
    private int price;
    @ManyToOne
    @JoinColumn(name ="category_id", referencedColumnName = "category_id")
    private Category category;
    @DateTimeFormat(pattern = "dd/MM/yyyy" )
    @Past(message = "That's impossible.")
    private Date dateRelease;

    public Product(int id, String name, int quantity, int price, Category category, Date dateRelease) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
        this.dateRelease = dateRelease;
    }

    public Product() {
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

    public Date getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(Date dateRelease) {
        this.dateRelease = dateRelease;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
