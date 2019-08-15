package com.vaibhav.assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private RadioButton selectedButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        final RadioButton sedan = (RadioButton) findViewById(R.id.radio1);
        final RadioButton hatchback = (RadioButton) findViewById(R.id.radio2);
        final RadioButton suv = (RadioButton) findViewById(R.id.radio3);

        final Button viewCar = (Button) findViewById(R.id.view);

        viewCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectId = radioGroup.getCheckedRadioButtonId();
                selectedButton = (RadioButton) findViewById(selectId);

                Intent intents= new Intent(getApplicationContext(), modelInfo.class); //Start "Sedan" Activity
                intents.putExtra("Model",selectedButton.getText());
                startActivityForResult(intents, 0);

            }
        });

    }

}
