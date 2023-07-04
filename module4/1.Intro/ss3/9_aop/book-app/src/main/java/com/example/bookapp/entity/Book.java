package com.example.bookapp.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private int bookId;
    @NotBlank( message = "Tên tiêu đề k dc để trống")
    private String title;
    @NotBlank( message = "Tên tác giả k dc để trống")
    private String author;
    @Column( name = "year_composed")
    @NotBlank( message = "Tên năm sáng tác k dc để trống")
    private String yearComposed;
    @Min(value = 0,message = "Sl phải lớn hơn 0")
    private int quantity;
    @OneToMany(mappedBy = "book")
    private List<Code> codes;

    public Book() {
    }

    public Book(int bookId, String title, String author, String yearComposed, int quantity, List<Code> codes) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.yearComposed = yearComposed;
        this.quantity = quantity;
        this.codes = codes;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYearComposed() {
        return yearComposed;
    }

    public void setYearComposed(String yearComposed) {
        this.yearComposed = yearComposed;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Code> getCodes() {
        return codes;
    }

    public void setCodes(List<Code> codes) {
        this.codes = codes;
    }
}
