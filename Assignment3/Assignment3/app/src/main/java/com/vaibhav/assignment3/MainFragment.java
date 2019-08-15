package com.vaibhav.assignment3;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import com.vaibhav.assignment3.BookItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    private GridView gridView;
    private static ArrayList<String> books=new ArrayList();
    public MainFragment() {
        if(books.size()==0)
            populateBooks();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        gridView = view.findViewById(R.id.mainFragmentGridView);
        final BookItemAdapter adapter = new BookItemAdapter(getContext(),books, this.getActivity());
        gridView.setAdapter(adapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Create a bundle to store the datz

                Bundle bundle = new Bundle();
                Log.d("Books",books.get(i));
                bundle.putString("BookName",books.get(i));

                int imageId = getResources().getIdentifier(books.get(i).toLowerCase(),"drawable",getContext().getPackageName());
                bundle.putInt("ImageId",imageId);

                // Create an object of second frag -> you need pass in the bundle data

                DetailsFragment detailsFragment = new DetailsFragment();

                detailsFragment.setArguments(bundle);

                // FSwitch the fragments
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                // enter the data for replacement
                transaction.replace(R.id.fragmentContainer,detailsFragment);

                // commit the changes
                transaction.commit();
            }
        });

        return view;

    }

    public void populateBooks()
    {
        for(int i=1;i<=20;i++)
            books.add("img"+i);
    }
}
