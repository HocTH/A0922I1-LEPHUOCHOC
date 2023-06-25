package com.example.blogpage.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "findProductByName",
                query = "select p from Blog p where p.name like '%:name%'")
})
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Tên không được để trống")
    private String name;
    @NotBlank(message = "Tác giả không được để trống")
    private String author;
    @NotBlank(message = "Nội dung không được để trống")
    private String content;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateRelease;

    public Blog(int id, String name, String author, String content, Category category, Date dateRelease) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.content = content;
        this.category = category;
        this.dateRelease = dateRelease;
    }

    public Date getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(Date dateRelease) {
        this.dateRelease = dateRelease;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Blog() {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
