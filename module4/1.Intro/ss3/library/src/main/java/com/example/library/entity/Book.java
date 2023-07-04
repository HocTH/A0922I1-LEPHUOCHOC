package com.example.library.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(columnDefinition = "varchar(100)", name = "name")
     private String name;
    @Column(columnDefinition = "varchar(100)", name = "author")
    private String author;
    @Column(columnDefinition = "varchar(500)", name = "definition")
    private String definition;
    @Column(name = "quantity")
    private int quantity;
    @OneToMany(mappedBy = "book")
    public List<BorrowBook> borrowBooks;

    public Book(int id, String name, String author, String definition, int quantity, List<BorrowBook> borrowBooks) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.definition = definition;
        this.quantity = quantity;
        this.borrowBooks = borrowBooks;
    }

    public Book() {
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

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<BorrowBook> getBorrowBooks() {
        return borrowBooks;
    }

    public void setBorrowBooks(List<BorrowBook> borrowBooks) {
        this.borrowBooks = borrowBooks;
    }
}
