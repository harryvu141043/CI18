package game.enemy;

import game.GameObject;
import game.physics.BoxCollider;
import game.player.Player;
import tklibs.SpriteUtils;

import java.awt.*;

public class EnemyBullet extends GameObject {
    public int damage;
    public EnemyBullet(){
        this.image= SpriteUtils.loadImage ( "assets/images/enemies/bullets/cyan.png" );
        velocity.set ( 0,3 );
        hitBox=new BoxCollider ( this,16,16 );
        damage=1;
    }
    public void render(Graphics g){
        g.drawImage ( this.image,(int) this.position.x,(int)this.position.y,null );
    }

    @Override
    public void run() {
        super.run ();
        this.checkplayer();
        this.deaticIfNeeded();
    }

    private void deaticIfNeeded() {
        if(position.y>600){
            this.deactive ();
        }
    }

    private void checkplayer() {
        Player player=GameObject.findIntersects ( Player.class,hitBox );
        if(player!=null){
            player.takeDamage1 ( damage );
            this.deactive ();
        }
    }
}
