package com.example.picturetnh.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.TimeZone;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;
    private int rate;
    @NotBlank(message = "Khong duoc de trong")
    private String author;
    @NotBlank(message = "Khong duoc de trong")
    private String feedBack;
    private Date date;
    private int likes = 0;

    public Comment(int id, int rate, String author, String feedBack, int likes) {
        this.id = id;
        this.rate = rate;
        this.author = author;
        this.feedBack = feedBack;
        this.likes = likes;
    }

    public Comment(int id, int rate, String author, String feedBack, Date date, int likes) {
        this.id = id;
        this.rate = rate;
        this.author = author;
        this.feedBack = feedBack;
        this.date = date;
        this.likes = likes;
    }

    public Date getDate() {
        return date;
    }

    public void setDate() {
        Date dateTime = new Date();
        TimeZone local = TimeZone.getDefault();
        TimeZone locale= TimeZone.getTimeZone("Asia/Ho_Chi_Minh");
        long local_time = dateTime.getTime() -local.getRawOffset()+ locale.getRawOffset();
        dateTime.setTime(local_time);
        this.date = dateTime;
    }

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
    public Date timezone(){
        Date dateTime = new Date();
        TimeZone local = TimeZone.getDefault();
        long local_time = dateTime.getTime() + local.getRawOffset();
        dateTime.setTime(local_time);
        return dateTime;
    }
}
