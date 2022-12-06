package com.example.homeworkkrivetsky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.homeworkkrivetsky.databinding.ActivityMainBinding;
import com.example.homeworkkrivetsky.databinding.ItemSectionBinding;
//import com.example.homeworkkrivetsky.databinding.ItemUserBinding;
import com.example.homeworkkrivetsky.databinding.ItemUserBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.Arrays;

/*
import ru.myitschool.lesson20221122.databinding.ActivityMainBinding;
import ru.myitschool.lesson20221122.databinding.ItemSectionBinding;
import ru.myitschool.lesson20221122.databinding.ItemUserBinding;*/


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private static final ListRepo repo = new ListRepo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fillList();

        //setContentView(R.layout.activity_main);
        //TextView textView = findViewById(R.id.outputText);
        binding.addContact.setOnClickListener(view -> addContact());
        binding.addSection.setOnClickListener(view -> addSection());
    }

    private void addSection() {
        String name = binding.inputName.getText().toString();

        if (!name.isEmpty()) {
            repo.addSection(new Section(name));

            fillList();
            clearInput();
        } else {
            Snackbar.make(binding.getRoot(),
                    "Заполните все поля",
                    Snackbar.LENGTH_SHORT).show();
        }
    }

    private void clearInput() {
        binding.inputName.setText("");
        binding.inputPhone.setText("");
        binding.inputName.clearFocus();
        binding.inputPhone.clearFocus();
        binding.radioGroup.clearCheck();
    }

    private void addContact() {
        String name = binding.inputName.getText().toString();
        String phone = binding.inputPhone.getText().toString();

        boolean isJunior = binding.radioJ.isChecked();
        boolean isMiddle = binding.radioM.isChecked();
        boolean isSenior = binding.radioS.isChecked();
        if (
                !name.isEmpty()
                        && !phone.isEmpty()
                        && (isJunior || isMiddle || isSenior)
        ) {
            Unit unit;

            if (isJunior) {
                unit = new Junior(name, phone);
                //userBinding.image.setImageResource(R.drawable.ic_junior);
                //userBinding.layoutUser.setBackgroundColor(Color.GREEN);

            } else if (isMiddle) {
                unit = new Middle(name, phone);
                //userBinding.layoutUser.setBackgroundColor(Color.YELLOW);
            } else {
                unit = new Senior(name, phone);
                //userBinding.image.setImageResource(R.drawable.ic_senior);
                //userBinding.layoutUser.setBackgroundColor(Color.RED);
            }
            repo.addUnit(unit);
            fillList();

            clearInput();
        } else {
            Snackbar.make(binding.getRoot(),
                    "Заполните все поля",
                    Snackbar.LENGTH_SHORT).show();
            //Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show();
        }
    }

    private void fillList() {
        binding.container.removeAllViews();

        for (Item item : repo.getItems()) {
            if (item instanceof Unit) {
                Unit unit = (Unit) item;
                ItemUserBinding userBinding = ItemUserBinding.inflate(getLayoutInflater());
                userBinding.name.setText(unit.getName());
                userBinding.phone.setText(unit.getPhone());
                userBinding.status.setText(unit.Speak());
                userBinding.getRoot().setTag(Arrays.asList(repo.getItems()).indexOf(unit));//
                binding.container.addView(userBinding.getRoot());
            } else if (item instanceof Section) {
                Section section = (Section) item;

                ItemSectionBinding sectionBinding = ItemSectionBinding.inflate(getLayoutInflater());
                sectionBinding.getRoot().setText(section.getName());

                binding.container.addView(sectionBinding.getRoot());
            }
        }
    }



    public void show_con(View view) {

        int t = (int) view.getTag();
        Unit unit = (Unit) repo.getItems()[t];


        Intent intent = new Intent(this, ShowActivity.class);


        intent.putExtra("name", unit.getName());
        intent.putExtra("phone", unit.getPhone() + " ");
        intent.putExtra("grade", unit.Speak());

        startActivity(intent);
    }
}