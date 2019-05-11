package tklibs;

import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Gamepanel extends JPanel {
    BufferedImage playerImage;
    BufferedImage background;
    Vector2D playerposition;

    //    ImageIcon background;
//    JLabel background;

    int playerX;
    int playerY;
    int backgroundX;
    int backgroundY;


    public Gamepanel() {
        playerposition=new Vector2D(200,500);
        playerImage = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        background=SpriteUtils.loadImage("assets/images/background/0.png");
//        background = new JLabel(new ImageIcon("assets/images/background/0.png"));
        playerX = 200;
        playerY = 500;
        backgroundX=0;
        backgroundY=600-3109;

    }


    @Override
    public void paint(Graphics g) {

        super.paint(g);
        g.setColor(new Color(227, 225, 215));

        g.drawImage(background,backgroundX,backgroundY,null);

//        g.drawRect(100,100,200,200);
//        g.fillRect(400,100,200,200);
        g.drawImage(playerImage,(int)playerposition.x,(int) playerposition.y, null);


    }


    public void gameloop() {
        long lasttime = 0;
        while (true) {
//            long currenttime=System.currentTimeMillis();
            long currenttime = System.nanoTime();
            if (currenttime - lasttime > 1000000000 / 60) {
                this.runall();
                //run logic
//                if (playerX==800){
//                    playerX=200;
//                }
//
                //render
//                System.out.println(currenttime - lasttime);
                this.repaint();
              lasttime = currenttime;
            }

        }
    }
    public void runall(){
//        if(playerX>=background.getWidth()-25){
//            playerX=background.getWidth()-25;
//        }
        playerposition.x=Mathx.clamp(playerposition.x,0,background.getWidth()-32);
        playerposition.y=Mathx.clamp(playerposition.y,0,600-48);
        if (KeyeventPress.isUpress){
            playerposition.y-=5;
        }
        if(KeyeventPress.isLeftress){
            playerposition.x-=5;
        }
        if (KeyeventPress.isDownress){
         playerposition.y+=5;
        }
        if(KeyeventPress.isRightress){
            playerposition.x+=5;
        }
//        if (uppress)
//        playerX++;

        if (backgroundY>=0){
            backgroundY=600-background.getHeight();
        }
        backgroundY++;
    }
}
//alt+enter:sửa lỗi code
//(fn)shift+f6:doi ten
//alt+ctrl+l:format code
