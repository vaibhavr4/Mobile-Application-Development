package com.vaibhav.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/*
Citation: Stack Overflow
 */
public class ChatScreenActivity extends AppCompatActivity {

    EditText messageBox;
    String messageBoxText = "";
    Button sendButton;
    ListView chatList;
    private DatabaseReference dbRootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_screen);

        dbRootRef = FirebaseDatabase.getInstance().getReference();
        final DatabaseReference dbChildRef = dbRootRef.child("UserMessages");

        messageBox = findViewById(R.id.messageBox);
        sendButton = findViewById(R.id.sendButton);
        sendButton.setEnabled(false);
        messageBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().trim().length()==0){
                    sendButton.setEnabled(false);
                } else {
                    sendButton.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loggedInEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();
                messageBoxText = messageBox.getText().toString();
                MessageModel messageModel = new MessageModel(loggedInEmail,messageBoxText);
                dbChildRef.push().setValue(messageModel);
                messageBox.setText("");

            }
        });
        MessageAdapter messageAdapter = new MessageAdapter(this, dbChildRef);
        chatList = findViewById(R.id.chatList);
        chatList.setAdapter(messageAdapter);

    }
}
