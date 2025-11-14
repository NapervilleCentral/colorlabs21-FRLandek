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
    System.out.println(s);
    System.out.println(b);
    int bucketsize1 = (b - s) / 4;
    int bucketsize2 = ((b - s) / 4) * 2;
    int bucketsize3 = ((b - s) / 4) * 3;
    int bucketsize4 = ((b - s) / 4) * 4;
    
    System.out.println(bucketsize1);
    System.out.println(bucketsize2);
    System.out.println(bucketsize3);
    System.out.println(bucketsize4);
    
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
    
   
   
  }//main
  public static int sum(Pixel px) { return px.getRed() + px.getBlue() + px.getGreen(); }
}//class