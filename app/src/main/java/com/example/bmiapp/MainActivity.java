package com.example.bmiapp;


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

import com.example.bmiapp.databinding.ActivityMainBinding;
import com.example.bmiapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    int intweight=55;
    int intage=22;
    int currentprogress;
    String mintprogress="170";
    String typeofuser="0";
    String weight2="55";
    String age2="22";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().hide();

        binding.male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                typeofuser="Male";
            }
        });

        binding.female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                typeofuser="Female";
            }
        });

        binding.seekbarforheight.setMax(300);
        binding.seekbarforheight.setProgress(170);
        binding.seekbarforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentprogress=progress;
                mintprogress=String.valueOf(currentprogress);
                binding.currentheight.setText(mintprogress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        binding.incrementage.setOnClickListener(view1 -> {
            intage=intage+1;
            age2=String.valueOf(intage);
            binding.currentage.setText(age2);
        });
        binding.decrementage.setOnClickListener(view1 -> {
            intage=intage-1;
            age2=String.valueOf(intage);
            binding.currentage.setText(age2);
        });
        binding.incrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intweight=intweight+1;
                weight2=String.valueOf(intweight);
                binding.currentweight.setText(weight2);
            }
        });
        binding.decrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intweight=intweight-1;
                weight2=String.valueOf(intweight);
                binding.currentweight.setText(weight2);
            }
        });

        binding.calculatembmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (typeofuser.equals("0"))
                {
                    Toast.makeText(getApplicationContext(),"SElect your Gender (:",Toast.LENGTH_SHORT).show();
                }
                else if (mintprogress.equals("0"))
                {
                    Toast.makeText(getApplicationContext(),"SElect your Height (:",Toast.LENGTH_SHORT).show();
                }
                else if (intage==0 || intage<0)
                {
                    Toast.makeText(getApplicationContext(),"Age is iccorrect ):",Toast.LENGTH_SHORT).show();
                }
                else if (intweight==0||intweight<0)
                {
                    Toast.makeText(getApplicationContext(),"weight is iccorrect ):",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent=new Intent(MainActivity.this,splash.class);
                    intent.putExtra("gender",typeofuser);
                    intent.putExtra("height",mintprogress);
                    intent.putExtra("weight",weight2);
                    intent.putExtra("age",age2);
                    startActivity(intent);
                }
            }
        });
    }
}