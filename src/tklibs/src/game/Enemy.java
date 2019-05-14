package game;

import tklibs.SpriteUtils;

public class Enemy extends GameObject {
    public Enemy(){

    }
    public int count=0;
    @Override
    public void run(){
        count++;
        if(count>200){
            this.image= SpriteUtils.loadImage ( "assets/images/enemies/level0/black/0.png" );
            position.set ( 100,200 );
        }
        this.position.y-=0.1;
    }
}
