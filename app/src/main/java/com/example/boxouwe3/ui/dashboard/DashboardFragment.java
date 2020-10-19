package com.example.boxouwe3.ui.dashboard;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.boxouwe3.NieuweAct;
import com.example.boxouwe3.R;

import static android.content.Intent.getIntentOld;
//waarom pakt die hem hier?


public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
   /* public void ActiviteitAanmaken(View v) {
        Intent intent2 = new Intent(getActivity(),
                NieuweAct.class);
        startActivity(intent2);
    }*/
   /* Button plusButton = (Button) findViewById(R.id.floatingActionButton2);
    plusButton.setOnClickListener(new OnClickListener(){
        public void onClick(View v){
            startActivity(new Intent(YourCurrentActivity.this, YourNewActivity.class));
        }
    });*/


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        final View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final View button = view.findViewById(R.id.floatingActionButton22);
        final View buttonUpdate = view.findViewById(R.id.Update);

        Intent intent = getActivity().getIntent();
        final String Naam = intent.getStringExtra("Name");
        //final String Naam = String.valueOf(intent.getIntExtra("Name", 0));
        final String Locatie = String.valueOf(intent.getIntExtra("Locatie", 0));

        //final TextView usertext = getActivity().findViewById(R.id.textViewUser);



        /*buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usertext.setText(Naam);


            }
        });*/



        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(getContext(), NieuweAct.class);
                        startActivity(i);
                       /* AanmakenActiviteitFragment nextFrag= new AanmakenActiviteitFragment();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.navigation_dashboard, nextFrag, "findThisFragment")
                                .addToBackStack(null)
                                .commit();*/
                    }
                }
        );
        /*Button plusknop;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_dashboard);
        plusknop = (Button) findViewById(R.id.floatingActionButton2);*/

        return view;
    }

   /* public void ActiviteitAanmaken() {
        Intent intent2 = new Intent(this,
                NieuweAct.class);
        startActivity(intent2);
    }
*/
    //LoggedInUser user = new LoggedInUser(java.util.UUID.randomUUID().toString(),
            //);
    //String userId = user.getuserId();
    //String DisplayName = user.getDisplayName();




}