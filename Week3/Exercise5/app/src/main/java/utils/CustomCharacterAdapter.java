package utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vaibhav.exercise5.R;

import java.util.ArrayList;

public class CustomCharacterAdapter extends BaseAdapter {

    //receive context from main activity
    Context context;

    //array list of data points to be populated
    ArrayList<CharacterInfoAdapterItem> characterItems;

    public CustomCharacterAdapter(Context context, ArrayList<CharacterInfoAdapterItem> characterItems) {
        this.context = context;
        this.characterItems = characterItems;
    }

    @Override
    public int getCount() {
        return characterItems.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        // create and return view
        if(view==null){
            view = View.inflate(context, R.layout.character_info_adapter_item,null);

            viewHolder = new ViewHolder();
            viewHolder.imageView = view.findViewById(R.id.characterImageAdapterItem);
            viewHolder.textView =  view.findViewById(R.id.characterNameAdapterItem);

            view.setTag(viewHolder);
        }

        else {
            viewHolder = (ViewHolder)view.getTag();
        }

        //grab child views from root view(Linear layout)
//        ImageView imageView = view.findViewById(R.id.characterImageAdapterItem);
//        TextView textView = view.findViewById(R.id.characterNameAdapterItem);

        //Overwrite values of child view based on input from MainActivity
        viewHolder.imageView.setImageResource(characterItems.get(i).imageResId);
        viewHolder.textView.setText(characterItems.get(i).charName);

        return view;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}
