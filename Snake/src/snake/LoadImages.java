/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


/**
 *
 * @author TranPhuocDu
 */
public class LoadImages {
    
    public static Image DauRan;
    public static Image Moi;
    
    public static Image Trangtri;
    public static Image Co;
    
    public static Image DauRan_Xuong;
    public static Image DauRan_Len;
    public static Image DauRan_Trai;
    public static Image DauRan_Phai;
    
    public static Image Moi1;
    public static Image Moi2;
    public static Image Moi3;

    public static BufferedImage bfi;
    public void Load()
    {
        try {
            //DauRan = ImageIO.read(new File("res/snake_head.png"));
            Trangtri = ImageIO.read(new File("res/Doraemon02.png"));
            //Co = ImageIO.read(new File("res/Co3.jpg"));
            bfi = ImageIO.read(new File("res/sprite1.png"));
            
            DauRan = bfi.getSubimage(2, 3, 30, 30);
            Moi = bfi.getSubimage(3, 46, 30, 30);
                      
            DauRan_Phai = bfi.getSubimage(110, 3,30, 30);
            DauRan_Len = bfi.getSubimage(145, 3,30, 30);
            DauRan_Xuong = bfi.getSubimage(39,3,30, 30);
            DauRan_Trai = bfi.getSubimage(74, 3,30, 30);
            
            Moi1 = bfi.getSubimage(35, 46, 25, 25);
            Moi2 = bfi.getSubimage(60, 46, 25, 25);

            
        } catch (IOException ex) {
        }
    }
}


