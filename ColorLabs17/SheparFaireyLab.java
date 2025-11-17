import java.awt.*;//the color class is in awt library
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
public class SheparFaireyLab
{

  public static void main(String[] args)
  {
     Picture me = new Picture("images/picofme.jpg");

     int red;
     int green;
     int blue;
     int avg;
     

    //grayscale
    Pixel[] pixels;
    pixels = me.getPixels();
    int bucketsize = pixels.length / 4;
   
    for (Pixel pixelObj : pixels) {
        red = pixelObj.getRed();
        green = pixelObj.getGreen();
        blue = pixelObj.getBlue();
        avg = (int)((red + green + blue) / 3);
        pixelObj.setRed(avg);
        pixelObj.setGreen(avg);
        pixelObj.setBlue(avg);
    }
   
    Arrays.sort(pixels, (p1, p2) -> Integer.compare(sum(p1), sum(p2)));
   
    for (int i = 0; i < pixels.length; i++) {
        Pixel p = pixels[i];
   
        if (i < bucketsize) {
            p.setRed(0);
            p.setGreen(50);
            p.setBlue(75);
        }
        else if (i > bucketsize && i < bucketsize * 2) {
            p.setRed(220);
            p.setGreen(25);
            p.setBlue(35);
        }
        else if (i > bucketsize * 2 && i < bucketsize * 3) {
            p.setRed(110);
            p.setGreen(150);
            p.setBlue(160);
        }
        else if (i > bucketsize * 3 && i < bucketsize * 4) {
            p.setRed(250);
            p.setGreen(230);
            p.setBlue(165);
        }
    }
   
   
    
    me.explore();
    me.write("images/method1.jpg");

    //-----------------------------------------------------
    //method 2
    
    int s = 255;
    int b = 0;
    
    
    for (Pixel pixelObj : pixels) {
        red = pixelObj.getRed();
        green = pixelObj.getGreen();
        blue = pixelObj.getBlue();
        avg = (int)((red + green + blue) / 3);
        pixelObj.setRed(avg);
        pixelObj.setGreen(avg);
        pixelObj.setBlue(avg);
    }
    pixels = me.getPixels();
    
    Arrays.sort(pixels, (p1, p2) -> Integer.compare(sum(p1), sum(p2)));
    
    for (Pixel pixelObj : pixels) {
        red = pixelObj.getRed();
        if (red < s) {
            s = red;
        }
        if (red > b) {
            b = red;
        }
    }

    int bucketsize1 = (b - s) / 4;
    int bucketsize2 = ((b - s) / 4) * 2;
    int bucketsize3 = ((b - s) / 4) * 3;
    int bucketsize4 = ((b - s) / 4) * 4;
    
    
    for (int i = 0; i < pixels.length; i++) {
        Pixel p = pixels[i];
        red = p.getRed();
        if (red < bucketsize1) {
            p.setRed(0);
            p.setGreen(50);
            p.setBlue(75);
        }
        else if (red < bucketsize2) {
            p.setRed(220);
            p.setGreen(25);
            p.setBlue(35);
        }
        else if (red < bucketsize3) {
            p.setRed(110);
            p.setGreen(150);
            p.setBlue(160);
        }
        else if (red < bucketsize4) {
            p.setRed(250);
            p.setGreen(230);
            p.setBlue(165);
        }
    }
    
    
    me.explore();
    me.write("images/method2.jpg");
    
    
    
    //-----------------------------------------------------
    //custom pic 1 -- this one looks ugly, gonna try different colors
    
    s = 255;
    b = 0;
    
    
    for (Pixel pixelObj : pixels) {
        red = pixelObj.getRed();
        green = pixelObj.getGreen();
        blue = pixelObj.getBlue();
        avg = (int)((red + green + blue) / 3);
        pixelObj.setRed(avg);
        pixelObj.setGreen(avg);
        pixelObj.setBlue(avg);
    }
    pixels = me.getPixels();
    
    Arrays.sort(pixels, (p1, p2) -> Integer.compare(sum(p1), sum(p2)));
    
    for (Pixel pixelObj : pixels) {
        red = pixelObj.getRed();
        if (red < s) {
            s = red;
        }
        if (red > b) {
            b = red;
        }
    }

    bucketsize1 = (b - s) / 4;
    bucketsize2 = ((b - s) / 4) * 2;
    bucketsize3 = ((b - s) / 4) * 3;
    bucketsize4 = ((b - s) / 4) * 4;
    
    
    for (int i = 0; i < pixels.length; i++) {
        Pixel p = pixels[i];
        red = p.getRed();
        if (red < bucketsize1) {
            p.setRed(170);
            p.setGreen(107);
            p.setBlue(57);
        }
        else if (red < bucketsize2) {
            p.setRed(170);
            p.setGreen(170);
            p.setBlue(57);
        }
        else if (red < bucketsize3) {
            p.setRed(35);
            p.setGreen(100);
            p.setBlue(103);
        }
        else if (red < bucketsize4) {
            p.setRed(170);
            p.setGreen(170);
            p.setBlue(57);
        }
    }
    
    
    me.explore();
    me.write("images/SFtry1.jpg");
    
    
//-----------------------------------------------------
    //custom pic 2 -- ben says it looks pretty picture but I have a better pallete I wanna try
    
    s = 255;
    b = 0;
    
    
    for (Pixel pixelObj : pixels) {
        red = pixelObj.getRed();
        green = pixelObj.getGreen();
        blue = pixelObj.getBlue();
        avg = (int)((red + green + blue) / 3);
        pixelObj.setRed(avg);
        pixelObj.setGreen(avg);
        pixelObj.setBlue(avg);
    }
    pixels = me.getPixels();
    
    Arrays.sort(pixels, (p1, p2) -> Integer.compare(sum(p1), sum(p2)));
    
    for (Pixel pixelObj : pixels) {
        red = pixelObj.getRed();
        if (red < s) {
            s = red;
        }
        if (red > b) {
            b = red;
        }
    }

    bucketsize1 = (b - s) / 4;
    bucketsize2 = ((b - s) / 4) * 2;
    bucketsize3 = ((b - s) / 4) * 3;
    bucketsize4 = ((b - s) / 4) * 4;
    
    
    for (int i = 0; i < pixels.length; i++) {
        Pixel p = pixels[i];
        red = p.getRed();
        if (red < bucketsize1) {
            p.setRed(173);
            p.setGreen(56);
            p.setBlue(62);
        }
        else if (red < bucketsize2) {
            p.setRed(176);
            p.setGreen(153);
            p.setBlue(57);
        }
        else if (red < bucketsize3) {
            p.setRed(65);
            p.setGreen(49);
            p.setBlue(121);
        }
        else if (red < bucketsize4) {
            p.setRed(173);
            p.setGreen(56);
            p.setBlue(62);
        }
    }
    
    
    me.explore();
    me.write("images/SFmyFinal.jpg");
    
    
//-----------------------------------------------------
    //custom pic 3 -- the yellow covers too much
    
    s = 255;
    b = 0;
    
    
    for (Pixel pixelObj : pixels) {
        red = pixelObj.getRed();
        green = pixelObj.getGreen();
        blue = pixelObj.getBlue();
        avg = (int)((red + green + blue) / 3);
        pixelObj.setRed(avg);
        pixelObj.setGreen(avg);
        pixelObj.setBlue(avg);
    }
    pixels = me.getPixels();
    
    Arrays.sort(pixels, (p1, p2) -> Integer.compare(sum(p1), sum(p2)));
    
    for (Pixel pixelObj : pixels) {
        red = pixelObj.getRed();
        if (red < s) {
            s = red;
        }
        if (red > b) {
            b = red;
        }
    }

    bucketsize1 = (b - s) / 4;
    bucketsize2 = ((b - s) / 4) * 2;
    bucketsize3 = ((b - s) / 4) * 3;
    bucketsize4 = ((b - s) / 4) * 4;
    
    
    for (int i = 0; i < pixels.length; i++) {
        Pixel p = pixels[i];
        red = p.getRed();
        if (red < bucketsize1) {
            p.setRed(94);
            p.setGreen(208);
            p.setBlue(0);
        }
        else if (red < bucketsize2) {
            p.setRed(13);
            p.setGreen(17);
            p.setBlue(163);
        }
        else if (red < bucketsize3) {
            p.setRed(233);
            p.setGreen(176);
            p.setBlue(0);
        }
        else if (red < bucketsize4) {
            p.setRed(94);
            p.setGreen(208);
            p.setBlue(0);
        }
    }
    
    
    me.explore();
    me.write("images/SFtry3.jpg");
    
    
    
//-----------------------------------------------------
    //custom pic 4 -- don't really like this one either, custom pic #2 is my favorite
    
    s = 255;
    b = 0;
    
    
    for (Pixel pixelObj : pixels) {
        red = pixelObj.getRed();
        green = pixelObj.getGreen();
        blue = pixelObj.getBlue();
        avg = (int)((red + green + blue) / 3);
        pixelObj.setRed(avg);
        pixelObj.setGreen(avg);
        pixelObj.setBlue(avg);
    }
    pixels = me.getPixels();
    
    Arrays.sort(pixels, (p1, p2) -> Integer.compare(sum(p1), sum(p2)));
    
    for (Pixel pixelObj : pixels) {
        red = pixelObj.getRed();
        if (red < s) {
            s = red;
        }
        if (red > b) {
            b = red;
        }
    }

    bucketsize1 = (b - s) / 4;
    bucketsize2 = ((b - s) / 4) * 2;
    bucketsize3 = ((b - s) / 4) * 3;
    bucketsize4 = ((b - s) / 4) * 4;
    
    
    for (int i = 0; i < pixels.length; i++) {
        Pixel p = pixels[i];
        red = p.getRed();
        if (red < bucketsize1) {
            p.setRed(173);
            p.setGreen(56);
            p.setBlue(62);
        }
        else if (red < bucketsize2) {
            p.setRed(176);
            p.setGreen(153);
            p.setBlue(57);
        }
        else if (red < bucketsize3) {
            p.setRed(65);
            p.setGreen(49);
            p.setBlue(121);
        }
        else if (red < bucketsize4) {
            p.setRed(173);
            p.setGreen(56);
            p.setBlue(62);
        }
    }
    
    
    me.explore();
    me.write("images/SFtry4.jpg");
    
   
   
  }//main
  public static int sum(Pixel px) { return px.getRed() + px.getBlue() + px.getGreen(); }
}//class