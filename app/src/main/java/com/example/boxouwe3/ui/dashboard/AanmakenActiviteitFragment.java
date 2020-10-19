package com.example.boxouwe3.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.boxouwe3.Activiteit;
import com.example.boxouwe3.MainActivity;
import com.example.boxouwe3.NieuweAct;
import com.example.boxouwe3.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AanmakenActiviteitFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AanmakenActiviteitFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Activiteit mActiviteit;
    private EditText EditTextNaam;
    private EditText EditTextLocatie;

    public AanmakenActiviteitFragment() {
        // Required empty public constructor
    }

    private View view;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AanmakenActiviteit.
     */
    // TODO: Rename and change types and number of parameters
    public static AanmakenActiviteitFragment newInstance(String param1, String param2) {
        AanmakenActiviteitFragment fragment = new AanmakenActiviteitFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Toolbar toolbar = toolbar.findViewById();
        //setSupportActionBar(toolbar);

            /*EditTextLocatie = EditTextLocatie.findViewById();

            FloatingActionButton fab = fab.findViewById();

            fab.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(getContext(), MainActivity.class);
                            if (EditTextNaam.getText().toString().equals("")
                                    || EditTextLocatie.getText().toString().equals("")) {
                                Toast.makeText(NieuweAct.this ,"Vul de gegevens alstublieft in", Toast.LENGTH_SHORT).show();
                            } else {
                                //String naam = String.
                            *//*i.putExtra("naam", (Parcelable) EditTextNaam);
                            i.putExtra("Locatie", (Parcelable) EditTextLocatie);*//*

                                startActivity(i);
                            }

                            //Intent i = new Intent(getApplicationContext(),MainActivity.class);
                            //stuur gegevens naar dashboard
                        *//*i.putExtras("Tutorial", description);
                        i.putExtra("NAAM", editText);*//*
                            //startActivity(i);

                        }
                    }
            );

      *//*  fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //stuur info naar database*//*

            //open het dashboard weer
            //Intent intent = new Intent(this, DashboardFragment.class);

            //stuur gegevens naar dashboard
            //intent.putExtras()
            //startActivity(intent);

               *//* Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*//*
        }
        //});
        public EditText getEditTextNaam() { return getEditTextNaam(); }
        public EditText getEditTextLocatie() { return getEditTextLocatie(); }
*/


  /*  @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_aanmaken_activiteit, container, false);
    }
}*/

    }
}