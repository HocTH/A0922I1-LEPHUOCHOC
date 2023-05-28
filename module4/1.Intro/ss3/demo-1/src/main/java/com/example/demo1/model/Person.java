package com.example.demo1.model;

public class Person {
    private String name;
    private String address;
    private String birthday;

    public Person(String name, String address, String birthday) {
        this.name = name;
        this.address = address;
        this.birthday = birthday;
    }

    public Person() {
    }

    public Person(String birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
