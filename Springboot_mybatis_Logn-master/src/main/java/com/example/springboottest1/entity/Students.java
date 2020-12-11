package com.example.springboottest1.entity;

import lombok.Data;

@Data
public class Students {
    private int age;
    private int score;
    private String name;

    public Students() {
        super();
    }

    public Students(int age, int score, String name) {
        super();
        this.age = age;
        this.score = score;
        this.name = name;
    }

    public Students(int age, int score){
        super();
        this.age = age;
        this.score = score;
    }

}