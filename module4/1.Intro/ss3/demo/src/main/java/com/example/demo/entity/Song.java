package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.GroupSequence;
import javax.validation.constraints.*;

@Entity

public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Not empty")
    @Size(max = 800,message = "so big")
    @Pattern(regexp = "^[a-zA-Z0-9]+$",message = "Not a special symbol")
    private String name;
    @NotBlank(message = "Not empty")
    @Size(max = 300,message = "so big")
    @Pattern(regexp = "^[a-zA-Z0-9]+$",message = "Not a special symbol")
    private String author;
    @NotBlank(message = "Not empty")
    @Size(max = 1000,message = "so big")
    @Pattern(regexp = "^[a-zA-Z0-9,]+$",message = "Not a special symbol")
    private String type;
    public Song() {
    }

    public Song(int id, String name, String author, String type) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
