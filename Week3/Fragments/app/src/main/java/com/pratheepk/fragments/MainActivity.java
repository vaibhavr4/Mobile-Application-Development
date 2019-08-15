package com.pratheepk.fragments;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Attach my fragment to the container that's present in  my layoyut

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // add a function to your transaction
        // 1. container ID - frame layout (MAIN xml) ; 2 - which fragment should I add?
        transaction.add(R.id.fragmentContainer, new MainFragment());

        // Commit the changes
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // add a function to your transaction
        // 1. container ID - frame layout (MAIN xml) ; 2 - which fragment should I add?
        transaction.replace(R.id.fragmentContainer, new MainFragment());

        // Commit the changes
        transaction.commit();
    }
}
