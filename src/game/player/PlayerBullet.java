package game.player;

import game.GameObject;
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
        this.image = SpriteUtils.loadImage ( "assets/images/player-bullets/a/1.png" );
//        velocity=new Vector2D ( 0,-6 );
//        velocity.setAngle ( -Math.PI/4 );
//        velocity.setAngle ( Math.toRadians ( -135 ) );
        velocity.set ( 0,-3 );
        hitBox=new BoxCollider ( this,24,24 );
        damage=1;
    }
    public void render(Graphics g) {
        g.drawImage (
                this.image,
                (int) this.position.x,
                (int) this.position.y,
                null
        );
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
