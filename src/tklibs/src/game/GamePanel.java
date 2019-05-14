package game;

import game.player.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Player player;
    Background background;
    Enemy enemy;

    public GamePanel() {

        this.background = new Background ();
//        this.player.position.set ( 200, 500 );
        this.player = new Player ();
        this.enemy=new Enemy ();

    }

    @Override
    public void paint(Graphics g) {
        super.paint ( g );
        for (int i=0;i<GameObject.objects.size ();i++){
            GameObject object=GameObject.objects.get ( i );
            if(object.active){
                object.render ( g );
            }
        }

//        this.background.render ( g );
//        this.player.render ( g );
//        for(game.player.PlayerBullet bullet:game.player.Player.playerBullets){
//            bullet.render ( g );
//        }
        g.setColor ( Color.cyan );
        g.drawRect ( 384, 0, 800 - 384, 600 );
        g.fillRect ( 384, 0, 800 - 384, 600 );

    }
    public void gameLoop() {
        long lastTime = 0;
        while (true) {
            long currentTime = System.currentTimeMillis ();
            if (currentTime - lastTime > 1000 / 80) {
                // run logic
                this.runAll ();
                // render
                this.repaint ();
                lastTime = currentTime;
            }
        }
    }
    public void runAll() {
//        this.player.run ();
//        this.background.run ();
        for (int i=0;i<GameObject.objects.size ();i++){
            GameObject object=GameObject.objects.get ( i );
            if(object.active){
                object.run ();
            }
        }
    }
}
