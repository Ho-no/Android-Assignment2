package com.example.android_assignment2_part2;

import static java.lang.Math.random;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    final String PROVIDER_NAME = "com.example.android_assignment2_part1.provider";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addData = findViewById(R.id.add_data);
        addData.setOnClickListener(v -> {
            Uri uri = Uri.parse("content://" + PROVIDER_NAME );
            ContentValues values = new ContentValues();
            Random random = new Random();
            values.put("id", random.nextInt());
            values.put("name", "Einstein");
            values.put("gender", "male");
            values.put("department", "market");
            values.put("salary", -500);
            getContentResolver().insert(uri, values);
        });

        startService(new Intent(getBaseContext(), SalaryService.class));

    }
}