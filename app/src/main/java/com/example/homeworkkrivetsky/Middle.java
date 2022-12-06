package com.example.homeworkkrivetsky;

public class Middle extends Unit{
    public Middle() {
    }

    public Middle(String name, String phone) {
        super(name, phone);
    }

    @Override
    public String Speak() {
        return "Middle";
    }
}
