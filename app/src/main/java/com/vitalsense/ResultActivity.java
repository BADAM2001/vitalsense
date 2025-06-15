package com.vitalsense;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private TextView textSpo2, textBP, textHeartRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textSpo2 = findViewById(R.id.textSpo2);
        textBP = findViewById(R.id.textBP);
        textHeartRate = findViewById(R.id.textHeartRate);

        int spo2 = getIntent().getIntExtra("spo2", 0);
        int bp = getIntent().getIntExtra("bp", 0);
        int heartRate = getIntent().getIntExtra("heartRate", 0);

        textSpo2.setText("SpO2: " + spo2 + "%");
        textBP.setText("Blood Pressure: " + bp + " mmHg");
        textHeartRate.setText("Heart Rate: " + heartRate + " bpm");
    }
}
