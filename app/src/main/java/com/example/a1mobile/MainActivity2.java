package com.example.a1mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    double grade1, grade2, average, grade3;
    String name, situation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent it = getIntent();
        grade1 = it.getDoubleExtra("grade1", 0.0);
        grade2 = it.getDoubleExtra("grade2", 0.0);
        average = it.getDoubleExtra("average", 0.0);
        name = it.getStringExtra("name");
        situation = it.getStringExtra("situation");

        Button calculateNewAverage = findViewById(R.id.btn_calculateA3);

        TextView tv1 = findViewById(R.id.tv_name);
        tv1.setText(String.valueOf(name));
        TextView tv2 = findViewById(R.id.tv_average);
        tv2.setText(String.valueOf(average));
        TextView tv3 = findViewById(R.id.tv_situation);
        tv3.setText(String.valueOf(situation));

        EditText et_grade3 = findViewById(R.id.et_grade3);

        calculateNewAverage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grade3 = Double.parseDouble(et_grade3.getText().toString());
                calculateNewAverage(grade3);
                activity3(view);
            }
        });
    }

    public double calculateNewAverage(double a3) {
        double grade1 = this.grade1;
        double grade2 = this.grade2;

        if (a3 < 5.0 && (a3 < grade1 && a3 < grade2)) {
            situation = "Nota da A3 insuficiente para substituição.";
            return 0;
        } else {
            if (grade1 > grade2 && a3 > grade2) {
                grade2 = a3;
            } else if (grade2 > grade1 && a3 > grade1) {
                grade1 = a3;
            } else {
                situation = "Nota da A3 menor A1 e A2";
                return 0;
            }
        }
        average = (grade1 + grade2) / 2;

        if (average >= 6.0) {
            situation = "APROVADO, Parabens, você conseguiu recuperar sua nota.";
        } else {
            situation = "REPROVADO, infelizmente você não passou nessa disciplina," +
                    " tente novamente no proximo periodo.";
        }
        return average;
    }

    public void activity3(View view) {
        Intent it_activity3 = new Intent(this, MainActivity3.class);
        it_activity3.putExtra("grade1", grade1);
        it_activity3.putExtra("grade2", grade2);
        it_activity3.putExtra("grade3", grade3);
        it_activity3.putExtra("name", name);
        it_activity3.putExtra("average", average);
        it_activity3.putExtra("situation", situation);
        startActivity(it_activity3);
    }

    public void backMainActivity(View view) {
        this.finish();
    }
}