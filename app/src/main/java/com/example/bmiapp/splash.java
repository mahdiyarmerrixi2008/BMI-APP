package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class splash extends AppCompatActivity {

    android.widget.Button mrecalulatembi;
    TextView mbmidisplay,mbmicatogry,mgender;
    Intent intent;
    ImageView mimageview;
    String mbmi;
    String height;
    float intbmi;
    String weight;
    float intheight,intweight;
    RelativeLayout mbachgroud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("result");
        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        intent=getIntent();
        mbmidisplay=findViewById(R.id.bmidisplay);
        mbmicatogry=findViewById(R.id.recalculatembi);
        mgender=findViewById(R.id.genderdisplay);
        mbachgroud=findViewById(R.id.contentlayout);
        mimageview=findViewById(R.id.imageview);
        mrecalulatembi=findViewById(R.id.recalculatembi);
        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");

        intheight=Float.parseFloat(height);
        intweight=Float.parseFloat(weight);
        intheight=intheight/100;
        intbmi=intweight/(intheight*intheight);
        mbmi=Float.toString(intbmi);

        if (intbmi<16)
        {
            mbmicatogry.setText("severe Thinness");
            mbachgroud.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.war);
        }

        else if (intbmi<16.9 && intbmi>16)
        {
            mbmicatogry.setText("moderate Thinness");
            mbachgroud.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.stop);
        }

        else if (intbmi<18.4 && intbmi>17)
        {
            mbmicatogry.setText("Mild Thinness");
            mbachgroud.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.war);
        }

        else if (intbmi<25 && intbmi>18.4)
        {
            mbmicatogry.setText("normal");
            mimageview.setImageResource(R.drawable.health);
        }
        else if (intbmi<29.4 && intbmi>25)
        {
            mbmicatogry.setText("overweight");
            mbachgroud.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.war);
        }
        else
        {
            mbmicatogry.setText("obese class I");
            mbachgroud.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.war);
        }
        mgender.setText(intent.getStringExtra("gender"));
        mbmidisplay.setText(mbmi);
        mrecalulatembi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(splash.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}