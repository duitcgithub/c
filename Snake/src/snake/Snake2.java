/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import java.awt.Point;

/**
 *
 * @author TranPhuocDu
 */
public class Snake2 extends Thread{

    Point p;

    public static boolean KT_QuayDau = false;
    public static boolean Dunggame = false;
    
    public static int X[] = new int[100];
    public static int Y[] = new int[100];
    
    
    static final int Up = 2;
    static final int Down = -2;
    static final int Left = 3;
    static final int Right = -3;

    public static int HuongDi = Snake2.Right;
    
    public static int DoDai;
    public static int Speed;
    
    
    int Xtam;
    int Ytam;
    
    
    
    public Snake2()
    {

        DoDai = 2;
        Speed = 300;
        Xtam = 1+ RandomSnake().x;
        Ytam = 1+ RandomSnake().y;
        
        X[0]= Xtam;
        Y[0]= Ytam;
        
        X[1]=Xtam - 1;
        Y[1]=Ytam ;
        
        X[2]=Xtam - 2;
        Y[2]=Ytam;
    }
    
    public Point RandomSnake()
    {
        Random rd = new Random();
        int x = rd.nextInt(24);
        int y = rd.nextInt(24);
        return new Point(x,y);
    }
    //
    public void LapHuongDi(int HD)
    {
        if(KT_QuayDau == true && HuongDi != -HD)
        {
            this.HuongDi =HD;
        
            KT_QuayDau = false;
        }
    }
    //
    public void Len()
    {
        Y[0]--;
    }
    
    public void Xuong()
    {
        Y[0]++;
    }
    public void Trai()
    {
        X[0]--;
    }
    public void Phai()
    {
        X[0]++;
    }
    
    //
    public void paint(Graphics g)
    {
        VeRan(g);
    }
    //
    public void VeRan(Graphics g)
    {
        for(int i = 1; i < DoDai+1; i++)
        {
                // dau ran
                g.setColor(Color.red);
                g.fill3DRect(X[0]*25, Y[0]*25,24,24, true); 
                 //Than ran
                g.setColor(Color.cyan);
                g.fill3DRect(X[i]*25, Y[i]*25,24,24, true); 
               
        }
    }
    //
    long t = 0;
    public void Update()
    {
        if(System.currentTimeMillis()-t > 100)
        {
            
            NoiRan();
            
            if(HuongDi == Snake2.Up)Len();
            if(HuongDi == Snake2.Down)Xuong();
            if(HuongDi == Snake2.Left)Trai();
            if(HuongDi == Snake2.Right)Phai();
            KT_QuayDau = true;
            //
            AnMoi();
            
            
            t = System.currentTimeMillis();
        }
         
        if(X[0] > 25) X[0] = 1;
        if(X[0] < 1) X[0] = 25;
        if(Y[0] > 25) Y[0] = 1;
        if(Y[0] < 1) Y[0] = 25;
    }

    
    public void AnMoi()
    {
        if(Moi.MoiNho[X[0]][Y[0]] == Moi.DiemCong10)
        {
            DoDai +=1;
            Speed-=10;
            Moi.MoiNho[X[0]][Y[0]]=0;
            Moi.MoiNho[RandomSnake().x][RandomSnake().y] = Moi.DiemCong10;
        }


        if(Moi.MoiLon[X[0]][Y[0]] == Moi.DiemCong15)
        {
            DoDai+=1;
            Speed-=10;
            Moi.MoiLon[X[0]][Y[0]]=0;
            Moi.MoiLon[RandomSnake().x][RandomSnake().y] = Moi.DiemCong15;
        }
    }
    
    //
    public void NoiRan()
    {
        for(int i=DoDai;i>0;i--)
        {
            X[i] = X[i-1];
            Y[i] = Y[i-1];
        }
    }
    //
    @Override
    public void run()
    {
        while(true)
        {
            if(Snake2.Dunggame)
            Update();
            try {
                sleep(Speed);
            } catch (InterruptedException ex) {
            }
        }
    }
    
    
}
