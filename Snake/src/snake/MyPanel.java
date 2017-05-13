/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author TranPhuocDu
 */
public class MyPanel extends JPanel implements Runnable{
    
    
    public static int Green_X = 25;
    public static int Green_Y = 25;
    
    public static int DoRongORan = 24;
   
    
    public static int Green_W = MyFrame.W - 312;
    public static int Green_H = MyFrame.H - 52;
    Random rd = new Random();
    
    
    
    Snake n ;
    Snake2 n2 ;
    Moi m;
    Moi m2;
    Thread thr ;
    public MyPanel()
    {
        n = new Snake(); 
        n2= new Snake2();
        m= new Moi();         
        KhoiTaoMoiDie();
        KhoiTaoMoiNho();
        KhoiTaoMoiLon();
        thr = new Thread(this);
        thr.start();
        
        
    }
    
    public void KhoiTaoMoiDie()
    {
        Moi.MoiDie[m.RandomMoi().x][m.RandomMoi().y]= Moi.Die;
    }
    public void KhoiTaoMoiNho()
    {
        Moi.MoiNho[m.RandomMoi().x][m.RandomMoi().y]= Moi.DiemCong10;
    }
    public void KhoiTaoMoiLon()
    {
        Moi.MoiLon[m.RandomMoi().x][m.RandomMoi().y]= Moi.DiemCong15;
    }
    
    @Override
    public void paint(Graphics g)
    { 
        paintGreen(g);
        //snake 1
        n.paint(g);
        //snake 2
        n2.paint(g);  
        
    }
    
    LoadImages load = new LoadImages();
    public void paintGreen(Graphics g)
    {
        g.setColor(Color.yellow);
        g.fillRect(0, 0, MyFrame.W, MyFrame.H);
        g.drawImage(load.Trangtri, 660,1, this);
        for(int i = 1; i <= Green_X; i++)
        {
            for(int j = 1; j <= Green_Y; j++)
            {
                //Duong Vien
                g.setColor(Color.red);
                g.drawRect(i, j, Green_W, Green_H);
                
                //Green Game
                g.setColor(Color.black);
                g.fillRect((i)*25, (j)*25, 24, 24);
                
                
                m.TaoMoi(g,i,j);  
            }
        }
    }
    
    long t1= 0;
    @Override
    public void run() {
        while(true)
        {
            if(Snake.DungGame)
            {
                if(System.currentTimeMillis() - t1 > 5000)
                {
                    KhoiTaoMoiDie();
                    t1 = System.currentTimeMillis();
                }
            }
            repaint();
            
            try {
                thr.sleep(100);
            } catch (InterruptedException ex) {
            }
        }
    }
}
