package snake;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TranPhuocDu
 */
public class ChuyenDong {
    
    LoadImages TaiImage = new LoadImages();
    
    public ChuyenDong()
    {
        TaiImage.Load();
    }
    
    long t =0;
    public void ChuyenDongDauRan(Graphics g,int x[] ,int y[])
    {
        
        if(System.currentTimeMillis()-t > 400)
        {        
            g.drawImage(TaiImage.DauRan, x[0]*25-3, y[0]*25-3, null);
            t = System.currentTimeMillis();
        
        }
            if(Snake.HuongDi == Snake.Right)
            {     
                g.drawImage(TaiImage.DauRan_Phai, x[0]*25-3, y[0]*25-3, null);       
            }
            if(Snake.HuongDi == Snake.Left)
            {
                g.drawImage(TaiImage.DauRan_Trai, x[0]*25-3, y[0]*25-3, null);
            }
            if(Snake.HuongDi == Snake.Up)
            {
                g.drawImage(TaiImage.DauRan_Len, x[0]*25-3, y[0]*25-3, null);
            }
            if(Snake.HuongDi == Snake.Down)
            {
                g.drawImage(TaiImage.DauRan_Xuong, x[0]*25-3, y[0]*25-3, null);
            }           
    }
    
    long t1 =0;
    long t2 =0;
    public  static int x = 0;
    public  static int x2 = 0;
    public void ChuyenDongMoi(Graphics g, int i,int j)
    {
        if(System.currentTimeMillis()-t1 > 17)
        {     
            x++;
            if(x >=2)
                x=0;
            
            if(x == 0)
            {
                g.drawImage(TaiImage.Moi, i, j, null);      
            }else
            {
                if(x == 1)
                    g.drawImage(TaiImage.Moi1, i, j, null);  
                else 
                    g.drawImage(TaiImage.Moi2, i, j, null);      
            }
            t1 = System.currentTimeMillis();
        }
          
    }
}