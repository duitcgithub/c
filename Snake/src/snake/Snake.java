/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;


import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Point;

/**
 *
 * @author TranPhuocDu
 */
public class Snake extends Thread{

    Point p;

    Moi m;
    public static boolean KT_QuayDau = false;
    public static boolean DungGame = false;
    public static boolean KT_GameOver = false;
    public static boolean ChuNhapNhay = true;
    public static boolean KT_ResetGame = false;
    
    public static int X[] = new int[100];
    public static int Y[] = new int[100];
    
    
    static final int Up = 2;
    static final int Down = -2;
    static final int Left = 3;
    static final int Right = -3;

    public static int HuongDi = Snake.Right;
    
    public static int DoDai;
    public static int Speed;
    
    public static int Diem ;
    public static int Level ;
    public static int HightCore ;
    public static int DoDaiTangLevel ;
    
    
    int Xtam;
    int Ytam;
    
    
    
    public Snake()
    {     
        DoDai = 2;
        Speed = 300;
        Diem = 0;
        Level = 1;
        DoDaiTangLevel = 6;
        
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
        int x = 1+rd.nextInt(24);
        int y = 1+rd.nextInt(24);
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
        Diem_Level(g);
        WinGame(g);
        DungGame_GameOver(g);
    }
    //
    LoadImages tai = new LoadImages();
    ChuyenDong cd = new ChuyenDong();
    public void VeRan(Graphics g)
    {
        tai.Load();
        for(int i = 1; i < DoDai+1; i++)
        {
            cd.ChuyenDongDauRan(g, X, Y);
            //g.drawImage(tai.DauRan_Phai ,X[0]*25-3, Y[0]*25-3, null);

            g.setColor(Color.white);
            g.fill3DRect(X[i]*25, Y[i]*25,24,24, true);            
        }
    }
    //
    public void ResetGame()
    {
        DoDai = 2;
        Speed = 300;
        Diem = 0;
        Level = 1;
        Xtam = 1+ RandomSnake().x;
        Ytam = 1+ RandomSnake().y;
        
        Snake.HuongDi = Snake.Right;
        X[0]= Xtam;
        Y[0]= Ytam;
        
        X[1]=Xtam - 1;
        Y[1]=Ytam ;
        
        X[2]=Xtam - 2;
        Y[2]=Ytam;
        Snake2.Dunggame = false;
    }
    //
    long t = 0;
    public void Update()
    {
        if(System.currentTimeMillis()-t > 100)
        {
            
            //
            AnMoi();
            
            //
            NoiRan();
            
            if(HuongDi == Snake.Up)Len();
            if(HuongDi == Snake.Down)Xuong();
            if(HuongDi == Snake.Left)Trai();
            if(HuongDi == Snake.Right)Phai();
            KT_QuayDau = true;
           //
            TangLevel();
            //
            KT_GameOver();
            
            //Neu Speed max thi thong bao win
           
            t = System.currentTimeMillis();
        }
        if(X[0] > 25) X[0] = 1;
        if(X[0] < 1) X[0] = 25;
        if(Y[0] > 25) Y[0] = 1;
        if(Y[0] < 1) Y[0] = 25;
    }
    
    public void KT_GameOver()
    {
        for(int i = 1; i < DoDai+1 ; i++)
        {
            if((Snake.X[0] == Snake.X[i] && Snake.Y[0] == Snake.Y[i]) || (Snake.X[0] == Snake2.X[0] && Snake.Y[0] == Snake2.Y[0])
                    || (Snake.X[0] == Snake2.X[i] && Snake.Y[0] == Snake2.Y[i]) || (Snake2.X[0] == Snake.X[i] && Snake2.Y[0] == Snake.Y[i]))
            {                    
                KT_GameOver = true;
            }
        }       
    }
    
    public void TangLevel()
    {
        if(Snake.DoDai == Snake.DoDaiTangLevel)
        {
            Level +=1;
            DoDaiTangLevel += DoDai/2-1;
        }
    }
    public void NoiRan()
    {
        for(int i=DoDai ; i > 0 ; i--)
        {
            X[i] = X[i-1];
            Y[i] = Y[i-1];
        }
    }
    //
    public void AnMoi()
    {
        if(Moi.MoiNho[X[0]][Y[0]] == Moi.DiemCong10)
        {
            DoDai++;
            Diem+=10;
            Speed -=5;
            Moi.MoiNho[X[0]][Y[0]]=0;
            Moi.MoiNho[RandomSnake().x][RandomSnake().y] = Moi.DiemCong10;
        }


        if(Moi.MoiLon[X[0]][Y[0]] == Moi.DiemCong15)
        {
            DoDai++;
            Diem+= 15;
            Speed-=10;
            Moi.MoiLon[X[0]][Y[0]]=0;
            Moi.MoiLon[RandomSnake().x][RandomSnake().y] = Moi.DiemCong15;
        }
        if(Moi.MoiDie[X[0]][Y[0]] == Moi.Die)
        {            
           Snake.KT_GameOver = true;
        }
    }
    
    public void WinGame(Graphics g)
    {
        if(Snake.Speed <= 10)
        { 
            DungGame = false;
        }
    }
    public void DungGame_GameOver(Graphics g)
    {
        if(Snake.KT_ResetGame)
        {
            Snake.HightCore = Snake.HightCore + Snake.Diem;
            ResetGame();
            
            Snake.KT_ResetGame = false;
            Snake.DungGame = false;
            Snake.KT_GameOver = false;
        }
        
        if(Snake.KT_GameOver) 
        {
            Snake.DungGame = false;
        }         
        
        if(!DungGame)
        {
            if(ChuNhapNhay)
            {   
                if(Snake.Speed <= 10)
                {
                            g.setColor(new Color(123854));
                            g.setFont(g.getFont().deriveFont(30.0f));
                            g.drawString("Bạn Đã Chiến Thắng", 180, 300);
                }
                else
                {
                    if(KT_GameOver == false)
                    { 
                        g.setColor(new Color(123854));
                        g.setFont(g.getFont().deriveFont(30.0f));
                        g.drawString("Dung Game! Press Space", 180, 300);   
                    }
                    else
                    {
                        g.setColor(Color.white);
                        g.setFont(g.getFont().deriveFont(30.0f));
                        g.drawString("GAME OVER", 250, 300);
                        g.setFont(g.getFont().deriveFont(30.0f));
                        g.setPaintMode();
                        g.drawString("PRESS ENTER! RESET NEW GAME", 100, 350);
                    }
                }
            }
            
        } 
        
    }
    
    public void Diem_Level(Graphics g)
    {
        
        g.setColor(new Color(1382600));
        g.setFont(g.getFont().deriveFont(30.0f));
        g.drawString("Điểm: "+Diem, 680, 380);
        
        g.setColor(new Color(01751));
        g.setFont(g.getFont().deriveFont(30.0f));
        g.drawString("Level: "+Level, 680, 430);
        
        g.setColor(new Color(765123));
        g.setFont(g.getFont().deriveFont(30.0f));
        g.drawString("Hight Core:"+HightCore, 680, 480);
        
    }
    @Override
    public void run()
    {
        while(true)
        {
            long t3 =0;
            if(System.currentTimeMillis()-t3 > 500)
            {
                Snake.ChuNhapNhay = !Snake.ChuNhapNhay;
            }

            if(Snake.DungGame)
                Update();
            try {
                sleep(Speed);
            } catch (InterruptedException ex) {
            }
        }
    }
    
    
}
