package com.vaibhav.assignment2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class modelInfo extends AppCompatActivity {

    ImageView carImage;
    TextView desc;
    Button viewWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_info);

        carImage = findViewById(R.id.carImage);
        desc = findViewById(R.id.desc);
        viewWeb = findViewById(R.id.viewWeb);
        final String modelFromPreviousActivity =getIntent().getStringExtra("Model");

        int imageResId = getResources().getIdentifier(modelFromPreviousActivity.toLowerCase(),"drawable",getPackageName());
        carImage.setImageResource(imageResId);

        int strId = getResources().getIdentifier(modelFromPreviousActivity.toLowerCase()+"_desc","string",getPackageName());
        desc.setText(strId);

        viewWeb.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Context context;
                int urlId = getResources().getIdentifier(modelFromPreviousActivity.toLowerCase()+"_url","string",getPackageName());
                String url= getResources().getString(urlId);
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

    }
}
