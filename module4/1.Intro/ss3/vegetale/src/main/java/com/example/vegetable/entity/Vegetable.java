package com.example.vegetable.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="Vegetable")
public class Vegetable {
    @Id
    private int id;
    @Column(columnDefinition = "nvarchar(100)")
    private String name;
    private double weight;
    private double price;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date importDay;
    @ManyToOne
    @JoinColumn(name ="type_id",referencedColumnName = "id_type")
    private Type type;

    public Vegetable() {
    }

    public Vegetable(int id, String name, double weight, double price, Date importDay, Type type) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.importDay = importDay;
        this.type = type;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getImportDay() {
        return importDay;
    }

    public void setImportDay(Date importDay) {
        this.importDay = importDay;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
