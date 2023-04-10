package com.example.a1mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    double grade1, grade2, average, grade3;
    String name, situation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent it = getIntent();
        grade1 = it.getDoubleExtra("grade1", 0.0);
        grade2 = it.getDoubleExtra("grade2", 0.0);
        grade3 = it.getDoubleExtra("grade3", 0.0);
        average = it.getDoubleExtra("average", 0.0);
        name = it.getStringExtra("name");
        situation = it.getStringExtra("situation");

        TextView tv1 = findViewById(R.id.tv_averageWithA3);
        tv1.setText(String.valueOf(average));
        TextView tv2 = findViewById(R.id.tv_newSituation);
        tv2.setText(String.valueOf(situation));
    }
    public void backMainActivity(View view) {
        this.finish();
    }
}