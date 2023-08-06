package com.example.countvisiter.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Counter {
    @Id
    private int count;
    public Counter(int count) {
        this.count = count;
    }

    public Counter() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public int increment(){
        return count++;
    }
}
