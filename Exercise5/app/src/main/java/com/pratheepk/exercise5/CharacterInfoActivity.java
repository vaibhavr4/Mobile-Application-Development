package com.pratheepk.exercise5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharacterInfoActivity extends AppCompatActivity {

    ImageView characterImage;
    TextView characterName;
    TextView characterDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_info);

        characterImage = findViewById(R.id.characterImg);
        characterName= findViewById(R.id.characterName);
        characterDescription = findViewById(R.id.characterDescription);

        //Extract resopurcenIDS - Image, TXT and Audio files

        String dataFromPreviousActivity = getIntent().getStringExtra("CharacterName");

        int imageResID = getResources().getIdentifier(dataFromPreviousActivity.toLowerCase(),"drawable",getPackageName());
        int textResID = getResources().getIdentifier(dataFromPreviousActivity.toLowerCase()+"text","raw",getPackageName());


        // Seeting the view attributes based on the data("Character Name") from previous activity
        characterImage.setImageResource(imageResID);
        characterName.setText(dataFromPreviousActivity);
        characterDescription.setText(ReadFromTXTFile(textResID));

    }




    private String ReadFromTXTFile(int resID){
        StringBuilder textValue = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getResources().openRawResource(resID)));

            String line;

            while ((line = reader.readLine()) != null) {
                textValue.append(line);
                textValue.append(' ');
            }
        }

        catch(IOException e){
            e.printStackTrace();
        }
      return textValue.toString();
    }
}
