package com.example.boxouwe3;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.boxouwe3.data.Database;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class NieuweAct extends AppCompatActivity {
    //private TextView mTextViewResult;
    private Activiteit mActiviteit;
    private EditText EditTextNaam;
    private EditText EditTextLocatie;

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nieuwe);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        EditTextNaam = findViewById(R.id.editTextNaam);
        EditTextLocatie = findViewById(R.id.editTextLocatie);

        FloatingActionButton fab = findViewById(R.id.fab21);

        fab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        if (EditTextNaam.getText().toString().equals("")
                                || EditTextLocatie.getText().toString().equals("")) {
                            Toast.makeText(NieuweAct.this, "Vul de gegevens alstublieft in", Toast.LENGTH_SHORT).show();
                        } else {
                            String name = EditTextNaam.getText().toString();
                            i.putExtra("name", String.valueOf(EditTextNaam));
                            i.putExtra("Locatie", String.valueOf(EditTextLocatie));
                            startActivityForResult(i, 1);
                        }

                    }
                }
        );
            }

    public EditText getEditTextNaam() { return getEditTextNaam(); }
    public EditText getEditTextLocatie() { return getEditTextLocatie(); }
    }


