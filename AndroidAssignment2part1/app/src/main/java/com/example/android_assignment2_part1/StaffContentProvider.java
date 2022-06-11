package com.example.android_assignment2_part1;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Room;

public class StaffContentProvider extends ContentProvider {
    static final String PROVIDER_NAME = "com.example.android_assignment2_part1.provider";
    static final String URL = "content://" + PROVIDER_NAME + "/staff";
    static Uri CONTENT_URI = Uri.parse(URL);

    AppDatabase db;

    @Override
    public boolean onCreate() {
        db = Room.databaseBuilder(this.getContext(),
                AppDatabase.class, "test.db").build();

        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return db.staffDAO().cursorGetALL();
    }

    @Override
    public String getType(Uri uri) {
        return "vnd.android.cursor.dir/vnd." + PROVIDER_NAME + "/staff";
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }


    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {


        return 0;
    }

}
