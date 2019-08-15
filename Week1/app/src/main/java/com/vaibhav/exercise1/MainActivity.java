package com.vaibhav.exercise1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    //1. link the view from layout to code
    //2. create an array and store various mood images


    ImageView ghostImage;

    int[] moodImages = {R.drawable.angry,R.drawable.exhausted,R.drawable.happy,R.drawable.neutral,R.drawable.sad};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ghostImage = findViewById(R.id.imageView);
    }

    // Function for button click

    public void changeMoodButton(View view)
    {
        Random random = new Random();

        int rNumber = random.nextInt(5);

        ghostImage.setImageResource(moodImages[rNumber]);

    }
}
