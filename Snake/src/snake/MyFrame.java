/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JFrame;

/**
 *
 * @author TranPhuocDu
 */
public class MyFrame extends JFrame{
    
    public static int W = 960;
    public static int H = 700;
    
    MyPanel mp ;
    Snake n ;
    Snake2 n2 ;
    Moi m;
    Dichuyen dc;
    
    Button btnResetGame;
    public MyFrame(String title)
    {
        super(title);
        mp= new MyPanel();
        add(mp);
        
        dc = new Dichuyen();
        this.addKeyListener(dc);
        
        m = new Moi();
        m.start();
        
        n = new Snake();
        n.start();

        n2 =new Snake2();
        n2.start();
        
        setBackground(Color.yellow);
        this.setBounds(200, 30, W, H);
        this.setResizable(false);
    }
    public static void main(String[] args) {
        MyFrame fr = new MyFrame("Snake");

        fr.setVisible(true);
        fr.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public class Dichuyen implements KeyListener
    {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            
            if(key == KeyEvent.VK_SPACE)
            {
                if(Snake.KT_GameOver == false && Snake.Speed > 10 )
                {
                    Snake.DungGame = !Snake.DungGame;
                    Snake2.Dunggame = !Snake2.Dunggame;
                }                
            }
            
            if(key == KeyEvent.VK_ENTER)
            {                
                Snake.KT_ResetGame = true;
            }
            if(key == KeyEvent.VK_UP)
            {
                n.LapHuongDi(Snake.Up);
                n2.LapHuongDi(Snake2.Down);
            }
            if(key == KeyEvent.VK_DOWN)
            {
                n.LapHuongDi(Snake.Down);
                n2.LapHuongDi(Snake2.Up);
            }
            if(key == KeyEvent.VK_RIGHT)
            {
                n.LapHuongDi(Snake.Right);
                n2.LapHuongDi(Snake2.Left);
            }
            if(key == KeyEvent.VK_LEFT)
            {
                n.LapHuongDi(Snake.Left);
                n2.LapHuongDi(Snake2.Right);
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}
