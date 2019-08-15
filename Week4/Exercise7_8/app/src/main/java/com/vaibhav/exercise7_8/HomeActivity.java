package com.vaibhav.exercise7_8;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class HomeActivity extends AppCompatActivity {

    ImageButton addImageButton;
    Button uploadButton;
    ImageView resultImageView;

    //uri of image from device
    Uri imageURIFromDevice;

    //declare request code for intent
    private final int REQUEST_CODE = 1;   //for gallery

    //variable to hold reference to firebase storage
    StorageReference storageRootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        addImageButton = findViewById(R.id.addImageButton);
        uploadButton = findViewById(R.id.uploadButton);
        resultImageView = findViewById(R.id.imageView);

        //set reference of firebase root storage
        storageRootRef = FirebaseStorage.getInstance().getReference();

        //include transition from home activity to gallery
        addImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //trigger implicit intent to grab image from other activity
                Intent implicitIntent = new Intent(Intent.ACTION_GET_CONTENT);

                //define file type
                implicitIntent.setType("image/*");

                //start intent
                startActivityForResult(implicitIntent,REQUEST_CODE);
            }
        });

        //upload image on click to storage
        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadImageToStorage();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //grab the data from gallery
        if(requestCode==REQUEST_CODE && resultCode==RESULT_OK)
        {
            // location of file in device
            imageURIFromDevice = data.getData();

            addImageButton.setImageURI(imageURIFromDevice);

        }
    }

    protected void uploadImageToStorage()
    {
        //create a filepath to store image in firebase
        final StorageReference filepath = storageRootRef.child("MyImages").child(imageURIFromDevice.getLastPathSegment());
        filepath.putFile(imageURIFromDevice).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                //notified if image has been uploaded to firebase

                //extract url of image
                filepath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        //result uri of image on web
                        Uri downloadUri = uri;
                        // pass uri and imageview to Picasso
                        Picasso.get().load(downloadUri).into(resultImageView);

                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }
}
