package game.player;

import game.GameObject;
import game.KeyEventPress;
import game.Renderer.Renderer;
import game.enemy.Enemy;
import game.items.Items;
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
//        this.image = SpriteUtils.loadImage ( "assets/images/players/straight/0.png" );
        renderer=new Renderer ( "assets/images/players/straight" );
        position.set ( 200, 500 );
        hitBox=new BoxCollider ( this,24,24 );
        hp=5;
        imune=false;
        damage=1;
    }
    @Override
    public void render(Graphics g) {
        if(imune){
            renderCount++;
            if(renderCount%2==0){
                super.render ( g );
            }
        }else {
            super.render (g);
        }

    }
    int renderCount=0;
    int count = 0;
    public int hp;
    public int damage;
    public boolean imune;

    @Override
    public void run() {
        this.move ();
        this.LimitPostion ();
        // player run
        this.shoot ();
        this.checkImune();
        this.checkItems ();

        System.out.println (renderCount);
    }
    int imuneCount;
    private void checkImune() {
        if(imune){
            imuneCount++;
            if(imuneCount>50){
                imune=false;
            }
        }else {
            imuneCount=0;
        }
    }
    public void takeHP(int addhp){
        hp+=addhp;
    }
    private void checkItems(){
        Items item=GameObject.findIntersects (Items.class,hitBox);
        if(item!=null){
            this.takeHP ( item.addhp );
            item.deactive ();
        }

    }

    public void takeDamage1(int damage){
        if(!imune){
            hp-=damage;
            if(hp<=0){
                hp=0;
                this.deactive ();
            }else {
                imune=true;
            }
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

