package game.enemy;

import game.GameObject;
import game.Renderer.Renderer;
import game.physics.BoxCollider;
import game.player.Player;
import tklibs.SpriteUtils;

import java.awt.*;
import java.net.URL;

public class Enemy extends GameObject {
    public int hp;
    public int damage;
    public Enemy(){
//        image= SpriteUtils.loadImage ( "assets/images/enemies/level0/pink/0.png" );
        renderer=new Renderer ("assets/images/enemies/level0/pink");
        position.set (0,-50 );
        velocity.set ( 0,1.5 );
        velocity.setAngle ( Math.toRadians ( 25 ) );
        hitBox=new BoxCollider ( this,28,28 );
        hp=3;
        damage=1;
    }
    public void takeDamage(int damage){
        hp-=damage;
        if(hp<=0){
            hp=0;
            this.deactive ();
        }
    }
    @Override
    public void run() {
        super.run ();
        this.move();
        this.shoot();
        this.deactiveIfNeeded();
        this.checkplayer ();
    }
    private void move() {
        if(this.onGoingRight()
                && this.outOfBoundRight()){
            this.reverseVelocityX();
        }
        if(this.onGoingLeft() && this.outOfBoundLeft()){
            this.reverseVelocityX ();
        }
    }

    private boolean outOfBoundLeft() {
        return position.x<=0;
    }

    private boolean onGoingLeft() {
        return velocity.x<0;
    }

    private void reverseVelocityX() {
        velocity.x=-velocity.x;
    }

    private boolean outOfBoundRight() {
        return position.x>384-32;
    }

    int count=0;

    private void shoot() {
        count++;
        if(count>=80){
            EnemyBullet bullet= GameObject.recycle ( EnemyBullet.class );
            bullet.position.set ( this.position );
            count=0;
        }
    }


    @Override
    public void reset() {
        super.reset ();
        position.set (0,-50 );
        velocity.set ( 0,1.5 );
        velocity.setAngle ( Math.toRadians ( 25 ) );
    }
    private void checkplayer() {
        Player player=GameObject.findIntersects ( Player.class,hitBox );
        if(player!=null){
            player.takeDamage1 ( damage );
            this.deactive ();
        }
    }
    private void deactiveIfNeeded() {
        if(position.y>600){
            this.deactive ();
        }
    }
    private boolean onGoingRight() {
        return velocity.x>0;
    }
}
