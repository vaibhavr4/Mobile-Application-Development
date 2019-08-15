package com.pratheepk.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {


    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_details, container, false);

        // Grab the data from previous fragment
        String datafromPreviousFragment = getArguments().getString("CharacterName");

        TextView textView = view.findViewById(R.id.fragment2textView);
        textView.setText(datafromPreviousFragment);

        return view;
    }

}
