package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    android.widget.Button mcalculatebmi;
    TextView mcurrentheight, mcurrentweight, mcurrentage;
    ImageView mincrementage, mincrementweight, mdecrementage, mdecrementweight;
    SeekBar mseekbarforheight;
    RelativeLayout male, female;

    public static int weight = 55;
    public static int age = 22;
    public static int currentprogress;
    public static String typeofuser = "0";

    float fheight, fweight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        mcalculatebmi = findViewById(R.id.calculatebmi);
        mcurrentage = findViewById(R.id.currentage);
        mcurrentweight = findViewById(R.id.currentweight);
        mcurrentheight = findViewById(R.id.currentHeight);
        mincrementage = findViewById(R.id.incrementage);
        mincrementweight = findViewById(R.id.incrementweight);
        mdecrementage = findViewById(R.id.decrementage);
        mdecrementweight = findViewById(R.id.decrementweight);
        mseekbarforheight = findViewById(R.id.seekbarforheight);


        male = findViewById(R.id.male);
        female = findViewById(R.id.female);

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalefocus));
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalenofocus));
                typeofuser = "Male";
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalefocus));
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalenofocus));
                typeofuser = "Female";
            }
        });

        mseekbarforheight.setMax(300);
        mseekbarforheight.setProgress(170);
        mseekbarforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentprogress = progress;
                mcurrentheight.setText(String.valueOf(currentprogress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mincrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                age++;
                mcurrentage.setText(String.valueOf(age));
            }
        });

        mdecrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                age--;
                mcurrentage.setText(String.valueOf(age));
            }
        });

        mincrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weight++;
                mcurrentweight.setText(String.valueOf(weight));
            }
        });

        mdecrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weight--;
                mcurrentweight.setText(String.valueOf(weight));
            }
        });


        mcalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (typeofuser == "0") {
                    Toast.makeText(MainActivity.this, "Select Your Gender First", Toast.LENGTH_SHORT).show();
                } else if (currentprogress == 0) {
                    Toast.makeText(MainActivity.this, "Select Your Height First", Toast.LENGTH_SHORT).show();
                } else if (age <= 0) {
                    Toast.makeText(MainActivity.this, "Age is Incorrect", Toast.LENGTH_SHORT).show();
                } else if (weight <= 0) {
                    Toast.makeText(MainActivity.this, "Weight is Incorrect", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, bmiactivity.class);
                    fheight = currentprogress;
                    fweight = weight;
                    intent.putExtra("gender", typeofuser);
                    intent.putExtra("height", fheight);
                    intent.putExtra("weight", fweight);
                    intent.putExtra("age", age);

                    startActivity(intent);
                }
            }
        });


    }
}