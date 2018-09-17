package com.example.root.tp1;

public class Category {
    private String name;
    private int id;

    private static int _id = 0;

    public Category(String name) {
        setName(name);
        setId(_id);
        _id++;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void setId(int id) {
        this.id = id;
    }
}
