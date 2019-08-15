package com.vaibhav.assignment3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

           View view = inflater.inflate(R.layout.fragment_details, container, false);

            // Grab the data from previous fragment
            ImageView imageView = view.findViewById(R.id.detailImage);
            TextView textView =  view.findViewById(R.id.bookDetails);

        String bookName = getArguments().getString("BookName");
        int imageRefId = getArguments().getInt("ImageId");

        imageView.setImageResource(imageRefId);

        int strId = getContext().getResources().getIdentifier(bookName+"_desc","string",getContext().getPackageName());

        textView.setText(strId);

        return view;
    }

}
