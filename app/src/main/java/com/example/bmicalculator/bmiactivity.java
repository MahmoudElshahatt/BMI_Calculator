package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class bmiactivity extends AppCompatActivity {
    android.widget.Button mrecalculatebmi;
    TextView mbmidisplay, mbmicateogory, mgender;
    ImageView mImageNiew;
    Intent intent;

    float floatheight, floatweight, floatbmi;
    RelativeLayout mbackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\">Result</font>"));
        intent = getIntent();

        mbmidisplay = findViewById(R.id.bmidisplay);
        mbmicateogory = findViewById(R.id.category);
        mgender = findViewById(R.id.genderdisplay);
        mbackground = findViewById(R.id.contentlayout);
        mImageNiew = findViewById(R.id.mimageView);
        mrecalculatebmi = findViewById(R.id.recalculatebmi);

        floatheight = intent.getFloatExtra("height", 0);
        floatweight = intent.getFloatExtra("weight", 0);

        floatheight = floatheight / 100;
        floatbmi = floatweight / (floatheight * floatheight);


        if (floatbmi < 16) {
            mbmicateogory.setText("Severe Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mImageNiew.setImageResource(R.drawable.warning);
        } else if (floatbmi < 16.9 && floatbmi > 16) {
            mbmicateogory.setText("Moderate Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mImageNiew.setImageResource(R.drawable.warning);
        } else if (floatbmi < 18.4 && floatbmi > 17) {
            mbmicateogory.setText("Mild Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mImageNiew.setImageResource(R.drawable.warning);
        } else if (floatbmi < 25 && floatbmi > 18.4) {
            mbmicateogory.setText("Normal");
            mImageNiew.setImageResource(R.drawable.ok);
        } else if (floatbmi < 29.4 && floatbmi > 25) {
            mbmicateogory.setText("Overweight");
            mbackground.setBackgroundColor(Color.RED);
            mImageNiew.setImageResource(R.drawable.warning);
        } else {
            mbmicateogory.setText("Obese Class I");
            mbackground.setBackgroundColor(Color.RED);
            mImageNiew.setImageResource(R.drawable.warning);
        }

        mgender.setText(intent.getStringExtra("gender"));
        mbmidisplay.setText(String.valueOf(floatbmi));

        mrecalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bmiactivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}