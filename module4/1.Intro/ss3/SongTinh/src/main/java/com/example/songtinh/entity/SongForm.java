package com.example.songtinh.entity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

public class SongForm {
    private int id;
    private String name;
    private String author;
    private String price;
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public SongForm(int id, String name, String author, String price, Category category, MultipartFile url) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.category = category;
        this.url = url;
    }

    private Category category;

    private MultipartFile url;

    public SongForm() {
    }

    public SongForm(int id, String name, String author, Category category, MultipartFile url) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.category = category;
        this.url = url;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public MultipartFile getUrl() {
        return url;
    }

    public void setUrl(MultipartFile url) {
        this.url = url;
    }
}
