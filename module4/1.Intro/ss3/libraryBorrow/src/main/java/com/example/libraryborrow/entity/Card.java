package com.example.libraryborrow.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.TimeZone;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_book", referencedColumnName = "id_book")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "id_student", referencedColumnName = "id_student")
    private Student student;
    private String status;
    private Date borrowedDay;
    private Date payDay;

    public Card(int id, Book book, Student student, String status, Date borrowedDay, Date payDay) {
        this.id = id;
        this.book = book;
        this.student = student;
        this.status = status;
        this.borrowedDay = borrowedDay;
        this.payDay = payDay;
    }

    public Card(Book book, Student student) {
        this.book = book;
        this.student = student;
    }

    public Card() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getBorrowedDay() {
        return borrowedDay;
    }

    public void setBorrowedDay() {
        Date dateTime = new Date();
        TimeZone local = TimeZone.getDefault();
        TimeZone locale= TimeZone.getTimeZone("Asia/Ho_Chi_Minh");
        long local_time = dateTime.getTime() -local.getRawOffset()+ locale.getRawOffset();
        dateTime.setTime(local_time);
        this.borrowedDay = dateTime;
    }

    public Date getPayDay() {
        return payDay;
    }

    public void setPayDay(Date payDay) {
        this.payDay = payDay;
    }
}
