package com.example.android_assignment2_part1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.bin.david.form.core.SmartTable;
import com.bin.david.form.data.style.FontStyle;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppDatabase db;
    private List<Staff> staffList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new OpenDatabase().execute();



    }

    private void updateTable() {
        if(staffList != null) {
            SmartTable<Staff> table = findViewById(R.id.table);

            table.setData(staffList);
            table.getConfig().setContentStyle(new FontStyle(50, Color.BLACK));
            Log.d("db", "updated");
        }
    }

    private class OpenDatabase extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            db = Room.databaseBuilder(getApplicationContext(),
                    AppDatabase.class, "test.db").build();

            //db.staffDAO().insertAll(new Staff("Tom", "male", "computer", 5400));
            staffList = db.staffDAO().getALL();
            Log.d("db", staffList.get(0).department);
            Log.d("db", "Opened");

            updateTable();
            return null;
        }
    }
}