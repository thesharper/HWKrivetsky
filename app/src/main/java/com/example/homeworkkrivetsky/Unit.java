package com.example.homeworkkrivetsky;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public abstract class Unit implements Item {
    private String name;
    private String phone;
    public static int ID;

    public abstract String Speak();

    {
        name="Test";
        phone="1234567890";
    }
    public Unit() {
    }

    public Unit(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public void onClick(View view) {
        /*Snackbar.make(
                view,
                Speak() + " | " + name + ": " + phone,
                Snackbar.LENGTH_SHORT
        ).show();*/







    }
}
