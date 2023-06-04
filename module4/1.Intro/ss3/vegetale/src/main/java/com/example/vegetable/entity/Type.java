package com.example.vegetable.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="type")
public class Type {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_type")
    private int idType;
    @Column(name = "name_type", columnDefinition = "nvarchar(50)")
    private String nameType;
@OneToMany(mappedBy = "type")
private List<Vegetable> vegetables;
    public Type() {
    }
    public Type(int idType, String nameType) {
        this.idType = idType;
        this.nameType = nameType;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int id) {
        this.idType = id;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public List<Vegetable> getVegetables() {
        return vegetables;
    }

    public void setVegetables(List<Vegetable> vegetables) {
        this.vegetables = vegetables;
    }
}
