/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TranPhuocDu
 */
public class Moi extends Thread{
    
    public static int MoiNho[][] = new int[100][100];
    public static int MoiLon[][] = new int[100][100];
    public static int MoiDie[][] = new int[100][100];    
    
    
    static int DiemCong10 = 10;
    static int DiemCong15 = 15;
    static int Die = 1;

    
    static int red;
    static int green;
    static int blue;
    
    Random r = new Random();
    
    LoadImages load = new LoadImages();
    ChuyenDong cd;
    
    public Moi()
    {
        cd = new ChuyenDong();     
    }
   
    public java.awt.Point RandomMoi()
    {
        Random rd = new Random();
        int x =1+ rd.nextInt(MyPanel.Green_X);
        int y =1+ rd.nextInt(MyPanel.Green_Y);
        return new java.awt.Point(x,y);
    }
 
    // 

    public void TaoMoi(Graphics g,int i,int j)
    {
        if(Moi.MoiLon[i][j] == DiemCong15)
        {
           
            //g.setColor(Color.pink);
            //g.fill3DRect(i*25, j*25,24,24, true); 
            cd.ChuyenDongMoi(g, i*25, j*25);
        }
        if(Moi.MoiDie[i][j] == Die)
        {           
            g.setColor(Color.red);
            g.fill3DRect(i*25, j*25,24,24, true); 
        }
        if(Moi.MoiNho[i][j] == DiemCong10)
        {
            g.setColor(new Color((red),(green),(blue)));  
            g.fill3DRect(i*25, j*25,24,24, true); 
            
        }
        
    }
    public void UpDateMoi()
    {
        long t = 0;
        if(System.currentTimeMillis() - t > 200)
        {
            red = r.nextInt(256);
            green = r.nextInt(256);
            blue = r.nextInt(256);
            t = System.currentTimeMillis();
        }
    }
    
    @Override
    public void run()
    {
        while(true)
        {    
            UpDateMoi();
            try {
                sleep(200);
            } catch (InterruptedException ex) {
                
            }
        }
        
    }
}
