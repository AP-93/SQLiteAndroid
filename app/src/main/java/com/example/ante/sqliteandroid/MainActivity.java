package com.example.ante.sqliteandroid;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ante.sqliteandroid.Data.Contract;
import com.example.ante.sqliteandroid.Data.DbHelper;

public class MainActivity extends AppCompatActivity {

    /**
     * Database helper that will provide us access to the database
     */
    private DbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.
        mDbHelper = new DbHelper(this);
    }

    public void insertHabit(String name, String date, int activity) {

        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a ContentValues object where column names are the keys,
        // and inserted data are the values.
        ContentValues values = new ContentValues();
        values.put(Contract.HabitEntry.USER_NAME, name);
        values.put(Contract.HabitEntry.ACTIVITY_DATE, date);
        values.put(Contract.HabitEntry.USER_ACTIVITY, activity);

        // The first argument for db.insert() is the habits table name.
        // The second argument provides the name of a column in which the framework
        // can insert NULL in the event that the ContentValues is empty (if
        // this is set to "null", then the framework will not insert a row when
        // there are no values).
        // The third argument is the ContentValues object containing the info for user activity data.
        db.insert(Contract.HabitEntry.TABLE_NAME, null, values);
    }

    /**
     * method to read and query database and return cursor with data
     */
    private Cursor readDatabaseInfo() {

        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        //in this case we are using all columns
        String[] projection = {
                Contract.HabitEntry._ID,
                Contract.HabitEntry.USER_NAME,
                Contract.HabitEntry.ACTIVITY_DATE,
                Contract.HabitEntry.USER_ACTIVITY
        };

        // Perform a query on the pets table
        Cursor cursor = db.query(
                Contract.HabitEntry.TABLE_NAME,   // The table to query
                projection,            // The columns to return
                null,                  // The columns for the WHERE clause
                null,                  // The values for the WHERE clause
                null,                  // Don't group the rows
                null,                  // Don't filter by row groups
                null);                   // The sort order

        return cursor;
    }
}
