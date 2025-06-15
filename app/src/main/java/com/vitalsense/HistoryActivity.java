package com.vitalsense;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.vitalsense.database.DatabaseHelper;
import com.vitalsense.models.Measurement;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    private ListView listView;
    private HistoryAdapter adapter;
    private DatabaseHelper dbHelper;
    private ArrayList<Measurement> measurements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        listView = findViewById(R.id.listView);
        dbHelper = new DatabaseHelper(this);
        measurements = dbHelper.getAllMeasurements();

        adapter = new HistoryAdapter(this, measurements);
        listView.setAdapter(adapter);
    }
}
