package com.example.android.database.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DOMINIC on 8/24/2017.
 */

public class contactoHelper extends SQLiteOpenHelper{
    public contactoHelper(Context context) {
        super(context, ContactoConstantes.DATABASE_NAME, null, ContactoConstantes.DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + ContactoConstantes.TABLE_CONTACTS + "(" + ContactoConstantes.TABLE_CONTACTS_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + ContactoConstantes.TABLE_CONTACTS_NAME + " TEXT, " +
                ContactoConstantes.TABLE_CONTACTS_TELEFONO + " TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //delete old table and create a new one
        db.execSQL("DROP TABLE IF EXISTS " + ContactoConstantes.TABLE_CONTACTS);
        onCreate(db);
    }
}
