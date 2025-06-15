package com.vitalsense;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vitalsense.models.Measurement;

import java.util.ArrayList;

public class HistoryAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Measurement> measurements;

    public HistoryAdapter(Context context, ArrayList<Measurement> measurements) {
        this.context = context;
        this.measurements = measurements;
    }

    @Override
    public int getCount() {
        return measurements.size();
    }

    @Override
    public Object getItem(int position) {
        return measurements.get(position);
    }

    @Override
    public long getItemId(int position) {
        return measurements.get(position).getId();
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_measurement, parent, false);

        TextView textSpo2 = convertView.findViewById(R.id.textSpo2);
        TextView textBP = convertView.findViewById(R.id.textBP);
        TextView textHeartRate = convertView.findViewById(R.id.textHeartRate);

        Measurement m = measurements.get(position);

        textSpo2.setText("SpO2: " + m.getSpo2() + "%");
        textBP.setText("BP: " + m.getBp() + " mmHg");
        textHeartRate.setText("HeartRate: " + m.getHeartRate() + " bpm");

        return convertView;
    }
}
