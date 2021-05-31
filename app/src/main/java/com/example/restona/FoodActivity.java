package com.example.restona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FoodActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button1,button2,button3,button4,button5,button6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent inti;
        switch(v.getId()){
            case R.id.button1 : inti = new Intent(this,Monday.class);startActivity(inti);break;
            case R.id.button2 : inti = new Intent(this,Tuesday.class);startActivity(inti);break;
            case R.id.button3 : inti = new Intent(this,Wednesday.class);startActivity(inti);break;
            case R.id.button4 : inti = new Intent(this,Thursday.class);startActivity(inti);break;
            case R.id.button5 : inti = new Intent(this,Friday.class);startActivity(inti);break;
            case R.id.button6 : inti = new Intent(this,Saturday.class);startActivity(inti);break;
            default:break;
        }
    }
}