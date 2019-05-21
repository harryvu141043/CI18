package game.player;

import game.GameObject;
import game.Renderer.Renderer;
import game.Vector2D;
import game.enemy.Enemy;
import game.physics.BoxCollider;
import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet extends GameObject {
//    public Vector2D position,position1;
//    public BufferedImage image,image1;
    public int damage;


    public PlayerBullet() {

        renderer=new Renderer ( "assets/images/player-bullets/a" );
        velocity.set ( 0,-6 );
        hitBox=new BoxCollider ( this,24,24 );
        damage=1;
    }

    @Override
    public void run() {

//        this.position.y -= 3;
//        position.add ( velocity.x,velocity.y );
        super.run ();
        this.deactiveIfNeeded ();
        this.checkEnemy ();
    }
    private void deactiveIfNeeded() {
        if (position.y<-30){
            this.deactive ();
        }
    }
    private void checkEnemy() {
        Enemy enemy=GameObject.findIntersects ( Enemy.class,hitBox );
        if(enemy!=null){
            enemy.takeDamage ( damage );
            this.deactive ();
        }
    }
}
