package com.example.android.database;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.database.database.ContactoConstantes;
import com.example.android.database.database.contactoHelper;

public class MainActivity extends AppCompatActivity {

    TextView tvFilas, tvTelefonos, tvNombres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvFilas = (TextView) findViewById(R.id.tvFilas);
        tvNombres = (TextView) findViewById(R.id.tvNombres);
        tvTelefonos = (TextView) findViewById(R.id.tvTelefonos);
    }
    //activity acts like a dialog box
    public void agregarContacto(View view){

        Intent intent = new Intent(this, MyDialog.class);
        startActivity(intent);
    }
    public void mostrarDB(View view){

        tvFilas.setText("Filas:");
        tvNombres.setText("Nombres:");
        tvTelefonos.setText("Telefonos:");

        //read database values
        contactoHelper cHelper = new contactoHelper(this);
        SQLiteDatabase db = cHelper.getReadableDatabase();
        String projection[] = {ContactoConstantes.TABLE_CONTACTS_ID, ContactoConstantes.TABLE_CONTACTS_NAME,
                ContactoConstantes.TABLE_CONTACTS_TELEFONO};
        //fetch the values. Returns the table data and store it in Cursor
        Cursor cursor = db.query(ContactoConstantes.TABLE_CONTACTS, projection, null, null, null, null, null);
        //use Cursor to travel the rows
        while(cursor.moveToNext()){

            tvFilas.setText(tvFilas.getText().toString() + " " + cursor.getInt(0) + ",");
            tvNombres.setText(tvNombres.getText().toString() + " " + cursor.getString(1) + ",");
            tvTelefonos.setText(tvTelefonos.getText().toString() + " " + cursor.getString(2) + ",");
        }
    }
}
