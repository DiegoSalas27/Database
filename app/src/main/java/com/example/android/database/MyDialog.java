package com.example.android.database;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.android.database.database.ContactoConstantes;
import com.example.android.database.database.contactoHelper;

public class MyDialog extends Activity {

    EditText etNombre, etTelefono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dialog);
        etNombre = (EditText) findViewById(R.id.etNombre);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
    }
    public void addContact(View view){

        contactoHelper contactoHelper = new contactoHelper(this);
        //insert data
        SQLiteDatabase db = contactoHelper.getWritableDatabase();
        //provide values
        ContentValues contentValues = new ContentValues();
        //implementation of hashmap
        contentValues.put(ContactoConstantes.TABLE_CONTACTS_NAME, etNombre.getText().toString());
        contentValues.put(ContactoConstantes.TABLE_CONTACTS_TELEFONO, etTelefono.getText().toString());
        //db.insert returns the last row id. Inserts the values
        db.insert(ContactoConstantes.TABLE_CONTACTS, null, contentValues);

        finish();
    }
}
