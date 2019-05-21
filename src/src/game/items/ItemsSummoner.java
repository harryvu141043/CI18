package game.items;

import game.GameObject;

import java.util.Random;

public class ItemsSummoner extends GameObject {
    public ItemsSummoner() {
    }
    int count=0;

    @Override public void run() {
        count++;
        Random rd=new Random ();
        if(count>160){
            Items item=GameObject.recycle ( Items.class );
            count=0;
        }

    }
}
