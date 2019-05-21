package game.Renderer;

import game.GameObject;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Renderer {
    public BufferedImage image;
    public ArrayList<BufferedImage> images;
    public int currentImageIndex;
    public int frameCount;
    public Renderer(String url) {
        File source=new File ( url );
        if(source.exists () && source.isFile ()){
            image= SpriteUtils.loadImage (url);
        }
        if(source.exists () && source.isDirectory ()){
            images=SpriteUtils.loadImages ( url );
            currentImageIndex=0;
            frameCount=0;
        }
    }

    public void render(Graphics g, GameObject master){
        if(image!=null){
            g.drawImage ( this.image,(int)master.position.x,(int)master.position.y,null );
       }
        if(images!=null){
            BufferedImage currentImage=images.get(currentImageIndex);
            g.drawImage ( currentImage,(int)master.position.x,(int)master.position.y,null );
            frameCount++;
            if(frameCount>10){
                currentImageIndex++;
                if(currentImageIndex>=images.size()){
                    currentImageIndex=0;
                }
                frameCount=0;
            }
        }
    }

}
