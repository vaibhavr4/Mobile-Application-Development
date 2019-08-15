package com.pratheepk.ml_classexercise;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.drm.DrmStore;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.face.FirebaseVisionFace;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetector;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Layout objects
    private ImageButton addImageButton;
    private TextView smileProbabilityTextView;


    //Variables for StartActivityForResult --> Grab image from device and store in Uri
    private Uri imageURIfromDevice;
    private static final int REQUEST_CODE=1;

    //variable to hold the bitmap
   private Bitmap sourceImageBitmap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Reference for Layout Objects
        addImageButton = findViewById(R.id.addImageButton);
        smileProbabilityTextView = findViewById(R.id.smileProbabilityText);

        //set onclicklistener on ImageButton --> open up gallery and pick and image
        addImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Extract the image from the gallery
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                //set the type of file to be selected
                intent.setType("image/*");
                // start th activity for result
                startActivityForResult(intent,REQUEST_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            // grab the data and set it on my image
            imageURIfromDevice = data.getData();// --> grabs the image from the gallery and provides the Uri

            //override add image button
            addImageButton.setImageURI(imageURIfromDevice);

            // take the image URI and convert to Bitmap
            try {
                sourceImageBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),imageURIfromDevice);

                // start the face detection process
                detectFaces(sourceImageBitmap);


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // method for handling face detection
    private void detectFaces(final Bitmap bitmapInputImage){
        //1. create firebase vision object -> BItmap(Input) -> firebaseVisionObject
        FirebaseVisionImage firebaseVisionImage = FirebaseVisionImage.fromBitmap(bitmapInputImage);

        //2. create detection options
        FirebaseVisionFaceDetectorOptions detectorOptions = new FirebaseVisionFaceDetectorOptions.Builder()
                .setPerformanceMode(FirebaseVisionFaceDetectorOptions.ACCURATE)
                .setLandmarkMode(FirebaseVisionFaceDetectorOptions.ALL_LANDMARKS)
                .setClassificationMode(FirebaseVisionFaceDetectorOptions.ALL_CLASSIFICATIONS)
                .build();

        //3. Initialize face detection engine
        FirebaseVisionFaceDetector faceDetector = FirebaseVision.getInstance()
                .getVisionFaceDetector(detectorOptions);


        //4. STart face detection
        faceDetector.detectInImage(firebaseVisionImage).addOnSuccessListener(new OnSuccessListener<List<FirebaseVisionFace>>() {


            @Override
            public void onSuccess(List<FirebaseVisionFace> firebaseVisionFaces) {
                Log.d("FACES",String.valueOf(firebaseVisionFaces.size()));

                // create copy of input bitmap image
                Bitmap copyOfInputImage = bitmapInputImage.copy(Bitmap.Config.ARGB_8888,true);
                addImageButton.setImageBitmap(copyOfInputImage);

                //define a canvas
                Canvas canvas = new Canvas(copyOfInputImage);
                Paint paint = new Paint();
                paint.setColor(Color.GREEN);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(4f);

                for(int i=0;i<firebaseVisionFaces.size();i++)
                {
                    canvas.drawRect(firebaseVisionFaces.get(i).getBoundingBox(),paint);

                    double smileProbability = firebaseVisionFaces.get(i).getSmilingProbability()*100;
                    smileProbabilityTextView.setText(String.valueOf(smileProbability));
                }


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });


    }
}
