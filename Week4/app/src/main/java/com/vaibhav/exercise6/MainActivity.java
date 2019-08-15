package com.vaibhav.exercise6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    ImageView ghostImage;
    DatabaseReference dbRootReference;

    int[] moodImages = {R.drawable.angry,R.drawable.exhausted,R.drawable.happy,R.drawable.neutral,R.drawable.sad};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ghostImage = findViewById(R.id.imageView);

        //get root reference of database
        dbRootReference = FirebaseDatabase.getInstance().getReference();

        //get the reference for child
        DatabaseReference dbChildReference = dbRootReference.child("ghostmood");

        //set a listener on child view to monitor the realtime updates
        dbChildReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int ghostIndex = dataSnapshot.getValue(int.class);

                //update ImageView based on data snapshot value
                ghostImage.setImageResource(moodImages[ghostIndex]);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
