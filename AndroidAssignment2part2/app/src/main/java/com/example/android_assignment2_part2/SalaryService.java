package com.example.android_assignment2_part2;

import android.app.Service;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.util.Timer;
import java.util.TimerTask;

public class SalaryService extends Service {
    public SalaryService() {
    }

    final String PROVIDER_NAME = "com.example.android_assignment2_part1.provider";

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void run() {
                Uri uri = Uri.parse("content://" + PROVIDER_NAME );
                Cursor cursor = getContentResolver().query(uri, null, null, null);

                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        String id = cursor.getString(cursor.getColumnIndex("id"));
                        String salary = cursor.getString(cursor.getColumnIndex("salary"));
                        String department = cursor.getString(cursor.getColumnIndex("department"));
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String gender = cursor.getString(cursor.getColumnIndex("gender"));

                        if (Float.parseFloat(salary) < 0) {
                            ContentValues values = new ContentValues();
                            values.put("id", id);
                            values.put("name", name);
                            values.put("gender", gender);
                            values.put("department", department);
                            values.put("salary", 0);

                            getContentResolver().update(uri, values, null, null);
                        }

                    }
                }
            }
        };

        timer.schedule(task, 0, 5000);
        return super.onStartCommand(intent, flags, startId);
    }
}