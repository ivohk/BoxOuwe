package com.example.boxouwe3;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.boxouwe3.data.Database;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class NieuweAct extends AppCompatActivity {
    //private TextView mTextViewResult;

    private EditText EditTextNaam;
    private EditText EditTextLocatie;
    //String description = "Tutorial";




    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nieuwe);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        EditTextNaam = findViewById(R.id.editTextNaam);
        EditTextLocatie = findViewById(R.id.editTextLocatie);

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(getApplicationContext(),MainActivity.class);
                        if (EditTextNaam.getText().toString().equals("")
                            || EditTextLocatie.getText().toString().equals("")) {
                            Toast.makeText(NieuweAct.this ,"Vul de gegevens alstublieft in", Toast.LENGTH_SHORT).show();
                        } else {
                           //String naam = String.
                            /*i.putExtra("naam", (Parcelable) EditTextNaam);
                            i.putExtra("Locatie", (Parcelable) EditTextLocatie);*/

                            startActivity(i);
                        }

                        //Intent i = new Intent(getApplicationContext(),MainActivity.class);
                        //stuur gegevens naar dashboard
                        /*i.putExtras("Tutorial", description);
                        i.putExtra("NAAM", editText);*/
                        //startActivity(i);

                    }
                }
        );

      /*  fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //stuur info naar database*/

                //open het dashboard weer
                //Intent intent = new Intent(this, DashboardFragment.class);

                //stuur gegevens naar dashboard
                //intent.putExtras()
                //startActivity(intent);

               /* Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        //});
    public EditText getEditTextNaam() { return getEditTextNaam(); }
    public EditText getEditTextLocatie() { return getEditTextLocatie(); }
    }

    /*public View verstuur() {
        Intent intent = new Intent(this, DashboardFragment.class);
        startActivity(intent);
        return view;
    }*/
