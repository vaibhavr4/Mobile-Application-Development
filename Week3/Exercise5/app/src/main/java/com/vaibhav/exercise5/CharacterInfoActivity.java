package com.vaibhav.exercise5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
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
        characterName = findViewById(R.id.characterName);
        characterDescription = findViewById(R.id.characterDescription);

        //Extract resource id for Image, TXT and Audio files
        String dataFromPreviousActivity = getIntent().getStringExtra("CharacterName");

        int imageResId = getResources().getIdentifier(dataFromPreviousActivity.toLowerCase(),"drawable",getPackageName());
        int textResId = getResources().getIdentifier(dataFromPreviousActivity.toLowerCase()+"text","raw",getPackageName());


        characterImage.setImageResource(imageResId);
        characterName.setText(dataFromPreviousActivity);
        characterDescription.setText(readFromTxt(textResId));

    }

    private String readFromTxt(int resId)
    {
        StringBuilder textValue = new StringBuilder();
        try
        {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(getResources().openRawResource(resId))
            );
            String line;
            while((line=reader.readLine())!=null)
            {
                textValue.append(line);
                textValue.append(' ');
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return textValue.toString();
    }
}
