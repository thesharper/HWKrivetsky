package com.example.homeworkkrivetsky;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        String name = getIntent().getStringExtra("name");
        String phone = getIntent().getStringExtra("phone");
        String grade = getIntent().getStringExtra("grade");

        TextView nametv = findViewById(R.id.contact_name);
        TextView phonetv = findViewById(R.id.contact_phone);
        TextView gradetv = findViewById(R.id.contact_grade);

        nametv.setText(name);
        phonetv.setText(phone);
        gradetv.setText(grade);
    }
}