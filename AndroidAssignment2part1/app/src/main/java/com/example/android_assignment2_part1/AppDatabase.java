package com.example.android_assignment2_part1;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = { Staff.class }, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract StaffDAO staffDAO();
}
