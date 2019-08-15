package utils;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pratheepk.exercise5.R;

import java.util.ArrayList;

public class CustomCharacterAdapter extends BaseAdapter {

    public CustomCharacterAdapter(Context context, ArrayList<CharacterInfoAdapterItem> characterItems) {
        this.context = context;
        this.characterItems = characterItems;
    }

    //Receive the context from main activity
    Context context;

    //ArrayList with the data points that are to be populated on my items that I'm creating
    ArrayList<CharacterInfoAdapterItem> characterItems;



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

        //Create and return the view

        if(view == null) {
            view = View.inflate(context, R.layout.character_info_adapter_item, null);

            Log.d("VIEWLOG", "New view created!");
        }
        // Grab the child view from your root view(Linear Layout)
        ImageView imageView = view.findViewById(R.id.characterImgAdapterItem);
        TextView textView = view.findViewById(R.id.characterNameAdapterItem);

        // Overwrite the values of the child views -> Based on the input I'm getting from the Mainactivity
        imageView.setImageResource(characterItems.get(i).getImageResID());
        textView.setText(characterItems.get(i).getCharacterName());


        return view;
    }
}
