package com.pratheepk.exercise5;

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
    ArrayList<CharacterInfoAdapterItem> favouriteCharacters = new ArrayList<CharacterInfoAdapterItem>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.myListView);


        //Populate the date into the array list
        PopulateList();


/*        ArrayAdapter myAdapter = new ArrayAdapter<String>( this,android.R.layout.simple_list_item_1
                , favouriteCharacters);*/

//Create and use my own adapter
        CustomCharacterAdapter myAdapter = new CustomCharacterAdapter(this,favouriteCharacters);


        //Connect the adapter to the list view
        listView.setAdapter(myAdapter);


        //Set the click listeners
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // trigger the second activity - character info
                Intent intent = new Intent(MainActivity.this, CharacterInfoActivity.class);

                // Pass in the character name to second activity
                intent.putExtra("CharacterName",favouriteCharacters.get(i).getCharacterName());
                startActivity(intent);
            }
        });


    }


    private void PopulateList(){

        // Populating my list with the data points that are to be shown by my Custom Adapter
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.batman,"Batman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.joker,"Joker"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.spiderman,"Spiderman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.thanos,"Thanos"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.batman,"Batman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.joker,"Joker"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.spiderman,"Spiderman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.thanos,"Thanos"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.batman,"Batman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.joker,"Joker"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.spiderman,"Spiderman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.thanos,"Thanos"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.batman,"Batman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.joker,"Joker"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.spiderman,"Spiderman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.thanos,"Thanos"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.batman,"Batman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.joker,"Joker"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.spiderman,"Spiderman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.thanos,"Thanos"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.batman,"Batman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.joker,"Joker"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.spiderman,"Spiderman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.thanos,"Thanos"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.batman,"Batman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.joker,"Joker"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.spiderman,"Spiderman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.thanos,"Thanos"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.batman,"Batman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.joker,"Joker"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.spiderman,"Spiderman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.thanos,"Thanos"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.batman,"Batman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.joker,"Joker"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.spiderman,"Spiderman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.thanos,"Thanos"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.batman,"Batman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.joker,"Joker"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.spiderman,"Spiderman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.thanos,"Thanos"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.batman,"Batman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.joker,"Joker"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.spiderman,"Spiderman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.thanos,"Thanos"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.batman,"Batman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.joker,"Joker"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.spiderman,"Spiderman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.thanos,"Thanos"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.batman,"Batman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.joker,"Joker"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.spiderman,"Spiderman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.thanos,"Thanos"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.batman,"Batman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.joker,"Joker"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.spiderman,"Spiderman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.thanos,"Thanos"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.batman,"Batman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.joker,"Joker"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.spiderman,"Spiderman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.thanos,"Thanos"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.batman,"Batman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.joker,"Joker"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.spiderman,"Spiderman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.thanos,"Thanos"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.thanos,"Thanos"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.batman,"Batman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.joker,"Joker"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.spiderman,"Spiderman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.thanos,"Thanos"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.batman,"Batman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.joker,"Joker"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.spiderman,"Spiderman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.thanos,"Thanos"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.batman,"Batman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.joker,"Joker"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.spiderman,"Spiderman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.thanos,"Thanos"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.batman,"Batman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.joker,"Joker"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.spiderman,"Spiderman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.thanos,"Thanos"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.thanos,"Thanos"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.batman,"Batman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.joker,"Joker"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.spiderman,"Spiderman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.thanos,"Thanos"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.batman,"Batman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.joker,"Joker"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.spiderman,"Spiderman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.thanos,"Thanos"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.batman,"Batman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.joker,"Joker"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.spiderman,"Spiderman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.thanos,"Thanos"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.batman,"Batman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.joker,"Joker"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.spiderman,"Spiderman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.thanos,"Thanos"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.thanos,"Thanos"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.batman,"Batman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.joker,"Joker"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.spiderman,"Spiderman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.thanos,"Thanos"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.batman,"Batman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.joker,"Joker"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.spiderman,"Spiderman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.thanos,"Thanos"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.batman,"Batman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.joker,"Joker"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.spiderman,"Spiderman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.thanos,"Thanos"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.batman,"Batman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.joker,"Joker"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.spiderman,"Spiderman"));
        favouriteCharacters.add(new CharacterInfoAdapterItem(R.drawable.thanos,"Thanos"));

    }
}
