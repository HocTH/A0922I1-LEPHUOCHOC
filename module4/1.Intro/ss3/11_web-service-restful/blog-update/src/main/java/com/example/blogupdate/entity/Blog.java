package com.example.blogupdate.entity;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name_blog")
    private String nameBlog;
    private String content;
    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "category_id")
    private Category category;

    public Blog() {
    }

    public Blog(int id, String nameBlog, String content, Category category) {
        this.id = id;
        this.nameBlog = nameBlog;
        this.content = content;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBlog() {
        return nameBlog;
    }

    public void setNameBlog(String nameBlog) {
        this.nameBlog = nameBlog;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String conten) {
        this.content = conten;
    }
}
