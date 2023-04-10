package com.example.a1mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    double grade1, grade2, average;
    String name, situation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_name = findViewById(R.id.et_name);
        EditText et_grade1 = findViewById(R.id.et_grade1);
        EditText et_grade2 = findViewById(R.id.et_grade2);
        Button calculate = findViewById(R.id.btn_calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grade1 = Double.parseDouble(et_grade1.getText().toString());
                grade2 = Double.parseDouble(et_grade2.getText().toString());
                name = et_name.getText().toString();
                average = calculateAverage(grade1, grade2);
                activity2(view);
            }
        });
    }

    public double calculateAverage(double a1, double a2) {
        double grade1;
        double grade2;

        if (a1 < 5.0 && a2 < 5.0) {
            situation = "REPROVADO";
            return average = 0;
        } else {
            if (a1 < 5.0) {
                grade1 = 0;
            } else {
                grade1 = a1;
            }
            if (a2 < 5.0) {
                grade2 = 0;
            } else {
                grade2 = a2;
            }
            average = (grade1 + grade2) / 2;

            if (average >= 6.0) {
                situation = "APROVADO";
            } else if (average < 6.0 && average >= 4.0) {
                situation = "Você ainda tem uma chance, " +
                        "insira uma nota de A3 para um novo cálculo de média";
            } else {
                situation = "REPROVADO";
            }

            return average;
        }
    }

    public void activity2(View view) {
        Intent it_activity2 = new Intent(this, MainActivity2.class);
        it_activity2.putExtra("grade1", grade1);
        it_activity2.putExtra("grade2", grade2);
        it_activity2.putExtra("name", name);
        it_activity2.putExtra("average", average);
        it_activity2.putExtra("situation", situation);
        startActivity(it_activity2);
    }
}