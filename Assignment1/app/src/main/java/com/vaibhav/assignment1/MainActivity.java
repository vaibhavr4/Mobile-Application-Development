package com.vaibhav.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toastMessage(View view)
    {
        Toast.makeText(getApplicationContext(),"Your Enrollment is complete!",Toast.LENGTH_SHORT).show();
    }

}
