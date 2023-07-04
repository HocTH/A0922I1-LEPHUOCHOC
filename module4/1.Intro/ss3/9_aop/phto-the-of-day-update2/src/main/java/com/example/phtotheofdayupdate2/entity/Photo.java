package com.example.phtotheofdayupdate2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
public class Photo {

    @Id
    @GeneratedValue
    private int id;
    @Column (name = "name_author")
    private String nameAuthor;
    @Column (name = "feed_back")
    private String feedBack;
    private String rating;
    private String date;
    private int likes;


    public Photo() {
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Photo(int id, String nameAuthor, String feedBack, String rating, String date, int likes) {
        this.id = id;
        this.nameAuthor = nameAuthor;
        this.feedBack = feedBack;
        this.rating = rating;
        this.date = date;
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public String getDate() {
        return date;
    }

    public void setDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate today = LocalDate.now();
        this.date = today.format(formatter);
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
