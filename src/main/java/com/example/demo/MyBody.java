package com.example.demo;

public class MyBody {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyBody{" +
            "name='" + name + '\'' +
            '}';
    }
}
