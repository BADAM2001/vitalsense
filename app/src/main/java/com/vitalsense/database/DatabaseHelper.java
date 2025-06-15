package com.vitalsense.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.vitalsense.models.Measurement;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Vitals.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "Measurements";
    private static final String COL_ID = "id";
    private static final String COL_SPO2 = "spo2";
    private static final String COL_BP = "bp";
    private static final String COL_HEARTRATE = "heartRate";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_SPO2 + " INTEGER, " +
                COL_BP + " INTEGER, " +
                COL_HEARTRATE + " INTEGER)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertMeasurement(Measurement measurement) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_SPO2, measurement.getSpo2());
        values.put(COL_BP, measurement.getBp());
        values.put(COL_HEARTRATE, measurement.getHeartRate());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<Measurement> getAllMeasurements() {
        ArrayList<Measurement> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(COL_ID));
                int spo2 = cursor.getInt(cursor.getColumnIndexOrThrow(COL_SPO2));
                int bp = cursor.getInt(cursor.getColumnIndexOrThrow(COL_BP));
                int heartRate = cursor.getInt(cursor.getColumnIndexOrThrow(COL_HEARTRATE));

                Measurement measurement = new Measurement(id, spo2, bp, heartRate);
                list.add(measurement);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }
}
