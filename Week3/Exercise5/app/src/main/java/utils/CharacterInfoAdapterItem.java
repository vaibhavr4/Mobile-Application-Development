package utils;

import com.vaibhav.exercise5.CharacterInfoActivity;

public class CharacterInfoAdapterItem {

    int imageResId;
    String charName;

    public CharacterInfoAdapterItem(int imageResId, String charName) {
        this.imageResId = imageResId;
        this.charName = charName;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }



}
