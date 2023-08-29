package com.example.randomizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public TextView StudentsNumber;
    public TextView StudentsLeft;
    public EditText editText;
    public boolean isNotGenerated = true;
    public ArrayList<Integer> numList = new ArrayList<>();
    public int leftCounter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StudentsNumber = findViewById(R.id.textView);
        StudentsLeft = findViewById(R.id.textView2);
        editText = findViewById(R.id.editTextNumberDecimal);
        editText.setCursorVisible(false);
        editText.setLongClickable(false);


    }

    public void onGenerate(View v) {
        if (isNotGenerated) {
            generate();
        } else {
            if (leftCounter >= 0) {
                StudentsNumber.setText(numList.get(leftCounter).toString());
                StudentsLeft.setText(Integer.toString(leftCounter));
                leftCounter--;
            } else {
                StudentsNumber.setText(numList.get(0).toString());
                clear();
            }
        }
    }

    public void onClear(View v) {
        clear();
    }

    public void onTeam(View v){
        Intent intent = new Intent(this, TeamActivity.class);
        startActivity(intent);
    }

    public void clear() {
        isNotGenerated = true;
        numList.clear();
        leftCounter = 0;
        StudentsNumber.setText("");
        StudentsLeft.setText("");
        editText.setInputType(2);
        editText.setSystemUiVisibility(1);
        editText.setText("");
    }


    public void generate() {
        try {
            if (editText.getText().toString().length() == 0) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Can't be less then one students", Toast.LENGTH_LONG);
                toast.show();
            } else if (Integer.parseInt(editText.getText().toString()) > 99) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Can't be more then ninety nine students", Toast.LENGTH_LONG);
                toast.show();
            } else {
                editText.setInputType(0);
                int numOfStudents = Integer.parseInt(editText.getText().toString());
                for (int i = 1; i <= numOfStudents; i++) {
                    numList.add(i);
                }
                Collections.shuffle(numList, new Random());
                leftCounter = numOfStudents - 1;
                isNotGenerated = false;
                StudentsNumber.setText(numList.get(leftCounter).toString());
                leftCounter--;
                StudentsLeft.setText(Integer.toString(leftCounter + 1));
            }
        } catch (Exception e) {
            clear();
        }
    }
}
