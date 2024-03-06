package com.example.sprawdzian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button oblicz = findViewById(R.id.oblicz);

        oblicz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText view_a = findViewById(R.id.input_a);
                EditText view_b = findViewById(R.id.input_b);
                EditText view_c = findViewById(R.id.input_c);
                EditText result = findViewById(R.id.result);
                result.setText("");

                double a = Double.parseDouble(view_a.getText().toString());
                double b = Double.parseDouble(view_b.getText().toString());
                double c = Double.parseDouble(view_c.getText().toString());

                Double delta = (b * b)-4*a*c;

                if (delta > 0){
                    double x1 = (-b+Math.sqrt(delta)) / (2*a);
                    double x2 = (-b-Math.sqrt(delta)) / (2*a);

                    result.setText("x1: "+ x1 + ", x2: " + x2);
                } else if (delta == 0) {
                    double x = -b / (2*a);

                    result.setText("x: "+x);
                } else if (delta < 0) {
                    Toast.makeText(getBaseContext(),"Brak rozwiazań",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}