package com.example.android_assignment2_part1;

import android.database.Cursor;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StaffDAO {
    @Query("SELECT * FROM staff")
    List<Staff> getALL();

    @Query("SELECT * FROM staff")
    Cursor cursorGetALL();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(Staff... staff);

    @Query("SELECT * FROM staff WHERE id = :id")
    Staff getStaffByID(int id);

    @Update
    void updateSalary(Staff staff);
}
