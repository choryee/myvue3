package com.example.myvue3.dao;

public enum Department {
    COMPUTER_SCIENCE("컴퓨터과학", 100),
    ENGINEERING("공학", 150),
    MATHEMATICS("수학", 50);

    private String name;
    private int capacity;

    Department(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

}
