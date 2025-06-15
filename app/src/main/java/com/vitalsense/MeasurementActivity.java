package com.vitalsense;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.vitalsense.database.DatabaseHelper;
import com.vitalsense.models.Measurement;

import java.util.Random;

public class MeasurementActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView textProgress;
    private Button buttonReset, buttonComplete;

    private int spo2, bp, heartRate;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement);

        progressBar = findViewById(R.id.progressBar);
        textProgress = findViewById(R.id.textProgress);
        buttonReset = findViewById(R.id.buttonReset);
        buttonComplete = findViewById(R.id.buttonComplete);

        dbHelper = new DatabaseHelper(this);

        startMeasurement();

        buttonReset.setOnClickListener(v -> resetMeasurement());

        buttonComplete.setOnClickListener(v -> {
            Measurement measurement = new Measurement(0, spo2, bp, heartRate);
            dbHelper.insertMeasurement(measurement);

            Intent intent = new Intent(MeasurementActivity.this, ResultActivity.class);
            intent.putExtra("spo2", spo2);
            intent.putExtra("bp", bp);
            intent.putExtra("heartRate", heartRate);
            startActivity(intent);
            finish();
        });
    }

    private void startMeasurement() {
        progressBar.setProgress(0);
        textProgress.setText("Starting Measurement...");

        new Handler().postDelayed(() -> {
            Random random = new Random();
            spo2 = 95 + random.nextInt(5);         // 95-99%
            bp = 110 + random.nextInt(20);         // 110-130 mmHg
            heartRate = 65 + random.nextInt(20);   // 65-85 bpm

            textProgress.setText("Measurement Complete");
            progressBar.setProgress(100);
            buttonComplete.setVisibility(View.VISIBLE);
            buttonReset.setVisibility(View.VISIBLE);
        }, 3000); // simulate 3 seconds measurement
    }

    private void resetMeasurement() {
        spo2 = 0;
        bp = 0;
        heartRate = 0;

        progressBar.setProgress(0);
        textProgress.setText("Measurement Reset");
        buttonComplete.setVisibility(View.INVISIBLE);
        buttonReset.setVisibility(View.INVISIBLE);

        // Restart measurement automatically after reset
        startMeasurement();
    }
}
