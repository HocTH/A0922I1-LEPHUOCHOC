package com.example.songtinh.entity;

import javax.persistence.*;
import java.util.List;
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;
    @Column(columnDefinition = "nvarchar(100)", name = "category_name")
    private String categoryName;
    @OneToMany(mappedBy = "category")
    List<Song> songList;

    public Category(int categoryId, String categoryName, List<Song> songList) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.songList = songList;
    }

    public Category() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }
}
