package game.player;

import game.GameObject;
import game.Vector2D;
import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet extends GameObject {
//    public Vector2D position,position1;
//    public BufferedImage image,image1;

    public PlayerBullet() {
        this.image = SpriteUtils.loadImage ( "assets/images/player-bullets/a/1.png" );
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
        this.position.y -= 10;
        this.deactiveIfNeeded ();
    }

    private void deactiveIfNeeded() {
        if (position.y<-30 || (position.y==230 && (50<=position.x && position.x<=130     ))){
            this.deactive ();
        }
    }

//        if(this.position1.y<=200){
//            this.position1.x-=20;
//        }
}
