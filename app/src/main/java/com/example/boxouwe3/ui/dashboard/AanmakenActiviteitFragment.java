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

    }
}