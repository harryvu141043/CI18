package game.player;

import game.GameObject;
import game.KeyEventPress;
import game.enemy.Enemy;
import game.physics.BoxCollider;
import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;

import java.util.ArrayList;

public class Player extends GameObject {
    //    public Vector2D position;
//    public BufferedImage image;
//    public static ArrayList<PlayerBullet> playerBullets=new ArrayList<> ();
    public Player() {
        this.image = SpriteUtils.loadImage ( "assets/images/players/straight/0.png" );
        position.set ( 200, 500 );
        hitBox=new BoxCollider ( this,24,24 );
        hp=5;
    }

    //    @Override
//    public void render(Graphics g){
//        super.render ( g );
////        g.drawImage(
////                this.image,
////                (int)this.position.x,
////                (int)this.position.y,
////                null
////        );
////        for(int i=0;i<playerBullets.size ();i++){
////           PlayerBullet bullet=playerBullets.get ( i );
////            bullet.render ( g );
////        }
//
//    }
    int count = 0;
    public int hp;
    public int damage;

    @Override
    public void run() {
        this.move ();
        this.LimitPostion ();
        // player run
        this.shoot ();

        System.out.println ( GameObject.objects.size () );
    }
    public void takeDamage1(int damage){
        hp-=damage;
        if(hp<=0){
            hp=0;
            this.deactive ();
        }
    }



    private void LimitPostion() {
        this.position.x = Mathx.clamp ( this.position.x, 0, 384 - 32 );
        // playerY [0, 600 - 48]
        this.position.y = Mathx.clamp ( this.position.y, 0, 600 - 48 );
        // background run
    }

    private void shoot() {
        count++;
        System.out.println (objects);
        if (KeyEventPress.isFirePress && count >= 19) {
            PlayerBullet newBullet = GameObject.recycle ( PlayerBullet.class );
            newBullet.position.set ( this.position );
            newBullet.velocity.setAngle ( Math.toRadians ( -180 ) );
            PlayerBullet newBullet2 = GameObject.recycle ( PlayerBullet.class );
            newBullet2.position.set ( this.position );
            newBullet2.velocity.setAngle ( Math.toRadians ( -90 ) );
            PlayerBullet newBullet3 = GameObject.recycle ( PlayerBullet.class );
            newBullet3.position.set ( this.position );
            newBullet3.velocity.setAngle ( Math.toRadians ( -60 ) );
            count = 0;
        }
    }

    private void move() {
        if (KeyEventPress.isUpPress) {
            this.position.y -= 5;
        }
        if (KeyEventPress.isLeftPress) {
            this.position.x -= 5;
        }
        if (KeyEventPress.isRightPress) {
            this.position.x += 5;
        }
        if (KeyEventPress.isDownPress) {
            this.position.y += 5;
        }
        // playerX [0, 384 - 32]
        this.position.x = Mathx.clamp ( this.position.x, 0, 384 - 32 );
        // playerY [0, 600 - 48]
        this.position.y = Mathx.clamp ( this.position.y, 0, 600 - 48 );
        // background run
    }
}

