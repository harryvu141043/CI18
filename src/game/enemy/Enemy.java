package game.enemy;

import game.GameObject;
import game.physics.BoxCollider;
import game.player.Player;
import tklibs.SpriteUtils;

import java.awt.*;
import java.net.URL;

public class Enemy extends GameObject {
    public int hp;
    public int damage;
    public Enemy(){
        image= SpriteUtils.loadImage ( "assets/images/enemies/level0/pink/0.png" );
        position.set (0,-50 );
        velocity.set ( 0,1.5 );
        velocity.setAngle ( Math.toRadians ( 25 ) );
        hitBox=new BoxCollider ( this,28,28 );
        hp=3;
        damage=5;
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
        if(this.onGoingRight()
                && position.x>384-32){
            velocity.x=-velocity.x;
        }
        if(velocity.x<0 && position.x<=0){
            velocity.x=-velocity.x;
        }
        this.shoot();
        this.deactiveIfNeeded();
        this.checkplayer ();
    }
    int count=0;

    private void shoot() {
        count++;
        if(count>=60){
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
