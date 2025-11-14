import java.awt.*;//the color class is in awt library
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
public class colorthing
{

  public static void main(String[] args)
  {
     Picture cp1 = new Picture("images/caterpillar.jpg");
     Picture cp2 = new Picture("images/caterpillar.jpg");
     Picture cp3 = new Picture("images/caterpillar.jpg");
     Picture cp4 = new Picture("images/caterpillar.jpg");
     Picture cp5 = new Picture("images/caterpillar.jpg");
     Picture cp6 = new Picture("images/caterpillar.jpg");
     Picture mark = new Picture("images/blue-mark.jpg");
     int red;
     int green;
     int blue;
     int avg;
     
     cp1.explore();
     
    //red factor 
    Pixel[] pixels;
    pixels = cp2.getPixels();
     
    
    for (Pixel pixelObj : pixels)
    {
        red = pixelObj.getRed();
        red = (int)(red * .25);
        pixelObj.setRed(red);
    }
    cp2.explore();
    
    
    //negate
    pixels = cp3.getPixels();
    
    for (Pixel pixelObj : pixels) {
        red = pixelObj.getRed();
        red = 255 - red;
        pixelObj.setRed(red);
        green = pixelObj.getGreen();
        green = 255 - green;
        pixelObj.setGreen(green);
        blue = pixelObj.getBlue();
        blue = 255 - blue;
        pixelObj.setBlue(blue);
    }
    cp3.explore();
    
    
    
    //grayscale
    pixels = cp4.getPixels();
    
    for (Pixel pixelObj : pixels) {
        red = pixelObj.getRed();
        green = pixelObj.getGreen();
        blue = pixelObj.getBlue();
        avg = (int)((red + green + blue) / 3);
        pixelObj.setRed(avg);
        pixelObj.setGreen(avg);
        pixelObj.setBlue(avg);
    }
    cp4.explore();
    
    
    //darken
    pixels = cp5.getPixels();
    
    for (Pixel pixelObj : pixels) {
        red = pixelObj.getRed();
        red -= 50;
        pixelObj.setRed(red);
        green = pixelObj.getGreen();
        green -= 50;
        pixelObj.setGreen(green);
        blue = pixelObj.getBlue();
        blue -= 50;
        pixelObj.setBlue(blue);
    }
    cp5.explore();
    
    
    
    //change color
    pixels = cp6.getPixels();
    
    for (Pixel pixelObj : pixels) {
        red = pixelObj.getRed();
        red -= 50;
        pixelObj.setRed(red);
        green = pixelObj.getGreen();
        green -= 20;
        pixelObj.setGreen(green);
        blue = pixelObj.getBlue();
        blue -= 100;
        pixelObj.setBlue(blue);
    }
    cp6.explore();
    
    
    
    //blueify
    pixels = mark.getPixels();
    
    for (Pixel pixelObj: pixels) {
        red = pixelObj.getRed();
        green = pixelObj.getGreen();
        blue = pixelObj.getBlue();
        int x = pixelObj.getX();
        int y = pixelObj.getY();
        
        if ( (x > 270 && x < 390) && (y > 170 && y < 330) ) {
            if ( (red > 70 && red < 215) && (green > 45 && green < 160) && (blue > 25 && blue < 150) ) {
                pixelObj.setBlue(blue + 100);
                pixelObj.setRed(red - 50);
                pixelObj.setGreen(green + 20);
            }
        }
    }
    
    
    
    mark.explore();
  }//main
}//class