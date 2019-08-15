package com.vaibhav.assignment4;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class MessageAdapter extends BaseAdapter {

    public MessageAdapter(Context context, DatabaseReference dbChildRef) {
        this.context = context;
        this.dbChildRef = dbChildRef;
        this.dbChildRef.addChildEventListener(dbChildListener);
        dataSnapshotResultsFromDB = new ArrayList<>();
    }

    private Context context;
    private DatabaseReference dbChildRef;
    private ArrayList<DataSnapshot> dataSnapshotResultsFromDB;
    private static final int SENDER = 0;
    private static final int RECEIVER = 1;
    private String loggedInUser = "";

    ChildEventListener dbChildListener = new ChildEventListener() {
        @Override
        public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            dataSnapshotResultsFromDB.add(dataSnapshot);
            notifyDataSetChanged();
        }

        @Override
        public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

        }

        @Override
        public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

        }

        @Override
        public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };

        @Override
    public int getCount() {
        return dataSnapshotResultsFromDB.size();
    }

    @Override
    public MessageModel getItem(int i) {
        DataSnapshot dataSnapshotItemFromList = dataSnapshotResultsFromDB.get(i);
        return dataSnapshotItemFromList.getValue(MessageModel.class);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        MessageModel messageModel = getItem(position);
        loggedInUser = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        return loggedInUser.equals(messageModel.getSender()) ? SENDER : RECEIVER;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        MessageModel messageModel = getItem(i);
        int userType = getItemViewType(i);
        // create and return view
        if(view==null){
            view = View.inflate(context, R.layout.adapter_list_item,null);

            viewHolder = new ViewHolder();
            viewHolder.senderEmail = view.findViewById(R.id.senderName);
            viewHolder.messageContent =  view.findViewById(R.id.messageText);

            view.setTag(viewHolder);
        }

        else {
            viewHolder = (ViewHolder)view.getTag();
        }

        switch (userType){
            case SENDER:
                viewHolder.senderEmail.setGravity(Gravity.END);
                viewHolder.messageContent.setGravity(Gravity.END);
                break;
            case RECEIVER:
                viewHolder.senderEmail.setGravity(Gravity.START);
                viewHolder.messageContent.setGravity(Gravity.START);
                break;
        }

        //Overwrite values of child view based on input from MainActivity
        viewHolder.senderEmail.setText(messageModel.getSender());
        viewHolder.messageContent.setText(messageModel.getMessageText());

        return view;

    };

    static class ViewHolder {
        TextView senderEmail;
        TextView messageContent;
    }
}
