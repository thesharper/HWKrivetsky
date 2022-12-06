package com.example.homeworkkrivetsky;

public class Senior extends Unit{
    public Senior() {
    }

    public Senior(String name, String phone) {
        super(name, phone);
    }

    @Override
    public String Speak() {
        return "Senior";
    }
}
