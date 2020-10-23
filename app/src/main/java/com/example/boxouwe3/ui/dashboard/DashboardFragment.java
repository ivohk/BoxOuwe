package com.example.boxouwe3.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.boxouwe3.NieuweAct;
import com.example.boxouwe3.R;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    //visuele elementen creëren
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
        //de twee buttons definiëren
        final View button = view.findViewById(R.id.floatingActionButton22);
        final View buttonUpdate = view.findViewById(R.id.Update);

        //onclick listener met nieuwe intent zodat het aanmaken van een nieuwe activiteit wordt gestart
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(getContext(), NieuweAct.class);
                        startActivity(i);
                    }
                }
        );
        //view moet te zien blijven
        return view;
    }
}