package com.example.appforlearningprocess_ass2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String [] river = {"Indus","Jhelum","Chenab","Kabul","Sutlej","Kunhar","Kurrem","Gomal"};
    String [] dams = {"Tarbela","Mangla","Raqal","Diamer Bhasha","Khanpur","Hub","Mirani","Warsak","Satpara","Neelum","Gulpur"};
    String [] lake = {"Lulusar","Saif-ul-Maluk","Lower Kachura","Mahodand","Attabad","Dudipatsar","Ansoo"};
    Button btnRiver, btnDam, btnLake;
    TextView textView, textViewAnswer, textViewRiverInfo,
            textViewDamInfo, textViewLakeInfo;
    int category = 0, index=0, riverCorrectCount, riverWrongCount,
            damCorrectCount, damWrongCount, lakeCorrectCount, lakeWrongCount;
    String answer = "";



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textViewRiverLakeDam);
        btnLake = findViewById(R.id.btnLake);
        btnLake.setOnClickListener(this);
        btnDam = findViewById(R.id.btnDam);
        btnDam.setOnClickListener(this);
        btnRiver = findViewById(R.id.btnRiver);
        btnRiver.setOnClickListener(this);
        textViewAnswer = findViewById(R.id.textViewRiverResult);
        textViewLakeInfo = findViewById(R.id.textViewResultLake);
        textViewDamInfo = findViewById(R.id.textViewResultDam);
        textViewRiverInfo = findViewById(R.id.textViewResultRiver);

        GenerateWord();


    }

    private void GenerateWord() {
        Random rnd = new Random();
        category = rnd.nextInt(3);
        if (category ==0){
            index = rnd.nextInt(river.length);
            textView.setText(river[index]);
            answer = "RIVER";
        } else if (category ==1){
            index = rnd.nextInt(dams.length);
            textView.setText(dams[index]);
            answer = "DAM";
        }else if (category ==2){
            index = rnd.nextInt(lake.length);
            textView.setText(lake[index]);
            answer = "LAKE";
        }
    }


    @Override
    public void onClick(View view) {

    }
}