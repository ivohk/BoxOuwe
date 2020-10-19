package com.example.boxouwe3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.boxouwe3.data.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ActiviteitenDB {
    private SQLiteDatabase mydatabase;
    private static NieuweAct sActiviteitenDB;
    private Context mContext;


    private ActiviteitenDB (Context context) {
        mContext = context.getApplicationContext();
        mydatabase = new Database(mContext).getWritableDatabase();
    }

    public List<Activiteit> getActiviteiten() {
        List<Activiteit> activiteiten = new ArrayList<>();
        Cursor cursor = mydatabase.rawQuery("SELECT * FROM Activiteiten", null );
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Activiteit activiteit = cursorToActiviteit(cursor);
                activiteiten.add(activiteit);
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return activiteiten;
    }
    // Activiteit activiteit = new Activiteit();

    private Activiteit cursorToActiviteit(Cursor cursor) {
        String uuidString = cursor.getString(
                cursor.getColumnIndex("id"));
        String title = cursor.getString(
                cursor.getColumnIndex("titel"));
        String naam = cursor.getString(
                cursor.getColumnIndex("beschrijving"));
        String Locatie = cursor.getString(
                cursor.getColumnIndex("locatie"));
        Activiteit activiteit = new Activiteit(UUID.fromString(uuidString));
        //Activiteit.setTitel(title);
        activiteit.setNaam(naam);
        activiteit.setLocatie(Locatie);
        return activiteit;
    }
    private static ContentValues getContentValues(Activiteit activiteit) {
        ContentValues values = new ContentValues();
        values.put("Naam", activiteit.getNaam());
        values.put("Locatie", activiteit.getLocatie());
        return values;
    }

    public void addActiviteit(Activiteit activiteit) {
        String sql = "INSERT INTO Activiteiten VALUES ('" + activiteit.getNaam() + "','" + activiteit.getLocatie() + "')";
        mydatabase.execSQL(sql);
    }









}
