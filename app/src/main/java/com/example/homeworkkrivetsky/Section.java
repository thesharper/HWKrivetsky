package com.example.homeworkkrivetsky;

import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class Section implements Item {
    private final String name;

    public Section(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void onClick(View view) {
        Snackbar.make(
                view,
                name,
                Snackbar.LENGTH_SHORT
        ).show();
    }
}
