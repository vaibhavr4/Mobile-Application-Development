package com.vaibhav.exercise5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import utils.CharacterInfoAdapterItem;
import utils.CustomCharacterAdapter;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> favouriteChar = new ArrayList<>();

    ArrayList<CharacterInfoAdapterItem> favCharacters = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.myListView);

        //Populate data to array list
        populateList();

        //Create an array adapter
        //ArrayAdapter myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, favouriteChar);

        //Create custom adapter
        CustomCharacterAdapter myAdapter = new CustomCharacterAdapter(this,favCharacters);

        //Connect the adapter to list view
        listView.setAdapter(myAdapter);

        //Set click listeners
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //trigger second activity - char info
                Intent intent = new Intent(MainActivity.this,CharacterInfoActivity.class);

                //pass char name to second activity
                intent.putExtra("CharacterName",favCharacters.get(i).getCharName());
                startActivity(intent);

            }
        });
    }

    private void populateList()
    {
//        favouriteChar.add("Batman");
//        favouriteChar.add("Joker");
//        favouriteChar.add("Spiderman");
//        favouriteChar.add("Thanos");

        favCharacters.add(new CharacterInfoAdapterItem(R.drawable.batman,"Batman"));
        favCharacters.add(new CharacterInfoAdapterItem(R.drawable.joker,"Joker"));
        favCharacters.add(new CharacterInfoAdapterItem(R.drawable.spiderman,"Spiderman"));
        favCharacters.add(new CharacterInfoAdapterItem(R.drawable.thanos,"Thanos"));

    }
}
