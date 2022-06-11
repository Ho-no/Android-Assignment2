package com.example.android_assignment2_part1;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.bin.david.form.annotation.SmartColumn;
import com.bin.david.form.annotation.SmartTable;

@Entity
@SmartTable(name = "Staff")
public class Staff {

    public Staff() {
    }

    @Ignore
    public Staff(int id, String name, String gender, String department, float salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
    }

    @PrimaryKey
    @SmartColumn(id = 0, name = "id")
    public int id;

    @ColumnInfo(name = "name")
    @SmartColumn(id = 1, name = "姓名")
    public String name;

    @ColumnInfo(name = "gender")
    @SmartColumn(id = 2, name = "性别")
    public String gender;

    @ColumnInfo(name = "department")
    @SmartColumn(id = 3, name = "部门")
    public String department;

    @ColumnInfo(name = "salary")
    @SmartColumn(id = 4, name = "工资")
    public float salary;

}
