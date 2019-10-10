package com.example.projectapp;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {

    private DBClass dbhelper;
    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbhelper = new DBClass(context);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbhelper.close();
    }


    public Cursor readEntry(String genderGroup, String age) {
        return database.rawQuery("SELECT i.food FROM foods i LEFT JOIN gender_group w ON i.gender_cat = w.id  WHERE w.name = ? AND i.age = ?", new String[]{genderGroup, age}, null);
    }

}
