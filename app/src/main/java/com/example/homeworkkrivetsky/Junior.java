package com.example.homeworkkrivetsky;

public class Junior extends Unit{
    public Junior() {
    }

    public Junior(String name, String phone) {
        super(name, phone);
    }

    @Override
    public String Speak() {
        return "Junior";
    }
}
