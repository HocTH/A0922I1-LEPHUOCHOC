package com.example.bookapp.entity;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Code {
    @Id
    @GeneratedValue
    private int id;
    @Range(min = 10000,max=99999)
    private Integer code;
    @NotBlank( message = "Trạng thái k đc để trống")
    private String status;
    @ManyToOne
    @JoinColumn(name = "book_id",referencedColumnName = "book_id")
    private Book book;

    public Code() {
    }

    public Code( Integer code, String status, Book book) {
        this.id = id;
        this.code = code;
        this.status = status;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
