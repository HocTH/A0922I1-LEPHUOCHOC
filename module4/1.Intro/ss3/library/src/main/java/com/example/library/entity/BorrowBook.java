package com.example.library.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BorrowBook {
    @Id
    @Column(name = "user_id")
    private int userId;
    @Column(columnDefinition = "varchar(100)", name = "user_name")
    private String userName;
    @Column(name="borrow_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date borrowDate;
    @Column(name="pay_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date payDate;
    @ManyToOne
    @JoinColumn(name = "id",referencedColumnName = "id")
    private Book book;
    @Column(name = "status")
    private boolean status;

    public BorrowBook(int userId, String userName, Date borrowDate, Date payDate, Book book, boolean status) {
        this.userId = userId;
        this.userName = userName;
        this.borrowDate = borrowDate;
        this.payDate = payDate;
        this.book = book;
        this.status = status;
    }

    public BorrowBook(int userId, String userName, Date borrowDate, Date payDate, Book book) {
        this.userId = userId;
        this.userName = userName;
        this.borrowDate = borrowDate;
        this.payDate = payDate;
        this.book = book;
    }

    public BorrowBook() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
