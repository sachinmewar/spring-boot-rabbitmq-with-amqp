package com.example.consumer.domain;

import java.io.Serializable;

public class Animal implements Serializable {
    String id;
    String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AnimalName{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
