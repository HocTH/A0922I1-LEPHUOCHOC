package com.example.libraryborrow.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue
    @Column(name = "id_student")
    private int idStudent;
    @Column(name = "name_student")
    private String nameStudent;
    @Column(name = "class_student")
    private String className;
    @OneToMany(mappedBy = "student")
    List<Card> cards;

    public Student() {
    }

    public Student(int idStudent, String nameStudent, String className) {
        this.idStudent = idStudent;
        this.nameStudent = nameStudent;
        this.className = className;
    }

    public Student(int idStudent, String nameStudent, String className, List<Card> cards) {
        this.idStudent = idStudent;
        this.nameStudent = nameStudent;
        this.className = className;
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

}
