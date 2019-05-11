package tklibs;

import javax.imageio.ImageIO;
import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Scanner;
import javax.swing.JLabel;

public class Program1 extends JFrame {
    public static void main(String[] args) {
//       Employee e1 = new Employee();
////        e1.eat();

        JFrame window = new JFrame();
        Gamepanel panel = new Gamepanel();
        panel.setPreferredSize(new Dimension(800,600));

//        JLabel background=new JLabel(new ImageIcon("assets/images/background/0.png"));
//        panel.add(background);

        window.add(panel);
        window.pack();
        window.setVisible(true);
        KeyAdapter keyhandler=new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()== KeyEvent.VK_W){
                    KeyeventPress.isUpress=true;
                }
                if(e.getKeyCode()== KeyEvent.VK_A){
                    KeyeventPress.isLeftress=true;
                }
                if(e.getKeyCode()== KeyEvent.VK_S){
                    KeyeventPress.isDownress=true;
                }
                if(e.getKeyCode()== KeyEvent.VK_D){
                    KeyeventPress.isRightress=true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println(e.getKeyCode());
                if(e.getKeyCode()==KeyEvent.VK_W){
                    KeyeventPress.isUpress=false;
                }
                if(e.getKeyCode()== KeyEvent.VK_A){
                    KeyeventPress.isLeftress=false;
                }
                if(e.getKeyCode()== KeyEvent.VK_S){
                    KeyeventPress.isDownress=false;
                }
                if(e.getKeyCode()== KeyEvent.VK_D){
                    KeyeventPress.isRightress=false;
                }

            }
        };
        window.addKeyListener(keyhandler);
//        window.setSize(800, 600);
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        window.setLocation(400, 400);
        window.setTitle("Touhou");
        panel.gameloop();

    }
}
