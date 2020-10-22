package com.example.boxouwe3;

import java.util.Date;
import java.util.UUID;

public class Activiteit {

    private UUID mId;
    private Date mDatum;
    private String mNaam;
    private String mLocatie;

    public Activiteit() {
        this(UUID.randomUUID());
    }

    public Activiteit(UUID id) {
        mId = id;
        mDatum = new Date();
        mNaam = "";
        mLocatie = "";
    }


    public void setNaam(String naam) {
        mNaam = naam;
    }

    public void setLocatie(String locatie) {
        mLocatie = locatie;
    }



    public String getNaam() {
        return getNaam();
    }

    public String getLocatie() {
        return getLocatie();
    }
}







