package game.items;

import game.GameObject;
import game.Renderer.Renderer;
import game.physics.BoxCollider;
import game.player.Player;

import java.awt.*;
import java.util.Random;

public class Items extends GameObject {
    public int x,y,addhp;
    public boolean qs;
    public Items(){
        Random rd=new Random ( );
        x=rd.nextInt ( 200 );
        y=rd.nextInt (200);
        qs=rd.nextBoolean ();
        hitBox=new BoxCollider ( this,12,12 );
        renderer=new Renderer ( "assets/images/items" );
        position.set (x,y);
        addhp=1;
    }

    @Override
    public void render(Graphics g) {
        super.render ( g );
        position.y+=2;
    }

    @Override
    public void run() {
        super.run ();
//        this.checkPlayer();
        this.deactiveIfNeeded();
    }

    private void deactiveIfNeeded() {
        if(position.y>600){
            this.deactive ();
        }
    }

//    private void checkPlayer() {
//        Player player=GameObject.findIntersects ( Player.class,hitBox );
//        if(player!=null){
//            player.takeHP ( addhp );
//            this.deactive ();
//        }
//    }

    @Override
    public void reset() {
        super.reset ();
        position.set ( x,y );
    }
}

