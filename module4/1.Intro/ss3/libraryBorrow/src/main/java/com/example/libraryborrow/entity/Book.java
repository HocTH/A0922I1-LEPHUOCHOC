package com.example.libraryborrow.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private int idBook;
    @Column(name = "name_book",columnDefinition = "nvarchar(200)")
    private String nameBook;
    private String author;
    private String description;
    private int quantity;
    @OneToMany(mappedBy = "book")
    List<Card> cards;

    public Book() {
    }

    public Book(int idBook, String nameBook, String author, String description, int quantity, List<Card> cards) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.author = author;
        this.description = description;
        this.quantity = quantity;
        this.cards = cards;
    }

    public Book(int idBook, String nameBook, String author, String description, int quantity) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.author = author;
        this.description = description;
        this.quantity = quantity;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
