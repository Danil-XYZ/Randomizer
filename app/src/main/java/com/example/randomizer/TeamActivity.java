package com.example.randomizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TeamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
    }

    public void onBack (View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void onBoop (){

    }
}