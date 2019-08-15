package com.vaibhav.assignment3;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BookItemAdapter extends BaseAdapter {
    private Activity activity;
    private ArrayList<String> books;

    Context context;

    public BookItemAdapter(Context context,ArrayList<String> books, Activity activity) {
        this.books = books;
        this.activity = activity;
        this.context=context;
    }
    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int i) {
        return books.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if(view==null){
            view = View.inflate(context, R.layout.book_item,null);

            viewHolder = new ViewHolder();
            viewHolder.imageView = view.findViewById(R.id.bookImage);
            viewHolder.textView =  view.findViewById(R.id.bookName);

            view.setTag(viewHolder);
        }

        else {
            viewHolder = (ViewHolder)view.getTag();
        }

        int strId = context.getResources().getIdentifier(books.get(i).toLowerCase(),"string",context.getPackageName());
        viewHolder.textView.setText(strId);
        int imageResID = context.getResources().getIdentifier(books.get(i).toLowerCase(),"drawable",context.getPackageName());
        viewHolder.imageView.setImageResource(imageResID);

        return view;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}
