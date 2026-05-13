
/**
 * Kevin Hayes
 * Test Picture Classes
 *
 * @author (Kevin Hayes)
 * @version (10-19-2016)
 */
import java.awt.*;//the color class is in awt library
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
public class TestPicture17
{
    static Picture temple = new Picture("images\\temple.jpg");
    static Picture apic = new Picture("images\\extreme.jpg");
    //static Picture apic = new Picture("images\\extreme_trans.png");
    static Picture canvas = new Picture("images\\7inX95in.jpg");
    //static Picture canvas = new Picture("images\\canvas.png");
    static int off;
    /**
     * main method, to test the picture
     *
     */
  public static void main(String[] args)
  {
     apic.explore();
     copytoCanvas(apic, canvas, 0, 0);
     copytoCanvas(apic, canvas, 240, 0);
     recursiveShrink(apic, canvas, 240, 0, 1);
     negate(apic, canvas, 480, 0);
     grayscale(apic, canvas, 0, 220);
     shepherdFairy(canvas, 240, 220);
     sepia(apic, canvas, 480, 220);
     brighten(apic, canvas, 0, 440, 2);
     mirrorVertical(canvas, 240, 440);
     darken(apic, canvas, 480, 440, 2);

    
    
    
    canvas.explore();
    canvas.write("images/finalcollage.jpg");

  }//main
  
  public static void fix(Picture apic) {
      int width = apic.getWidth();
      int mirrorPoint = width/2;
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      
      //loop through all the rows
      for (int y = 30; y <= 92; y++) {
          //loop from 0 to the middle (mirror point)
          for (int x = 0; x < mirrorPoint; x++) {
              leftPixel = apic.getPixel(x,y);
              rightPixel = apic.getPixel(width - 1 -x, y);
              rightPixel.setColor(leftPixel.getColor());
          }
      }
  }
  public static void mirrorVertical(Picture target, int posX, int posY) {
      Picture pic = new Picture("images/extreme.jpg");
      int height = pic.getHeight();
      int mirrorPoint = height/2;
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      
      //loop through all the rows
      for (int y = 0; y < pic.getHeight(); y++) {
          //loop from 0 to the middle (mirror point)
          for (int x = 0; x < mirrorPoint; x++) {
              leftPixel = pic.getPixel(y,x);
              rightPixel = pic.getPixel(y, height - x -1);
              rightPixel.setColor(leftPixel.getColor());
          }
      }
      copytoCanvas(pic, target, posX, posY);
  }
  public static void recursiveShrink(Picture source, Picture target, int x, int y, int add) {
      Pixel sourcePix = null;
      Pixel targetPix = null;
      
      add *= 2;
      System.out.println("shrink");
    
      if (add <= 10) {
          //loop thru the columns (targetX is the starting point on Canvas)
          for (int sourceX = 0, targetX = x; sourceX < source.getWidth(); sourceX+=add, targetX++) {
              //loop thru the rows
              for (int sourceY = 0, targetY = y; sourceY < source.getHeight(); sourceY+=add, targetY++) {
                  sourcePix = source.getPixel(sourceX,sourceY);
                  targetPix = target.getPixel(targetX, targetY);
                  targetPix.setColor(sourcePix.getColor());
              }
          }
          recursiveShrink(source, target, x, y, add);
      }

  }
  public static void negate(Picture source, Picture target, int x, int y) {
      Pixel sourcePix = null;
      Pixel targetPix = null;
      //loop thru the columns (targetX is the starting point on Canvas)
      for (int sourceX = 0, targetX = x; sourceX < source.getWidth(); sourceX++, targetX++) {
          //loop thru the rows
          for (int sourceY = 0, targetY = y; sourceY < source.getHeight(); sourceY++, targetY++) {
              sourcePix = source.getPixel(sourceX,sourceY);
              targetPix = target.getPixel(targetX, targetY);
              int r = 255 - sourcePix.getRed();
              int g = 255 - sourcePix.getGreen();
              int b = 255 - sourcePix.getBlue();
              targetPix.setColor(new Color(r,g,b));
          }
      }
  }
  public static void grayscale(Picture source, Picture target, int x, int y) {
      Pixel sourcePix = null;
      Pixel targetPix = null;
      //loop thru the columns (targetX is the starting point on Canvas)
      for (int sourceX = 0, targetX = x; sourceX < source.getWidth(); sourceX++, targetX++) {
          //loop thru the rows
          for (int sourceY = 0, targetY = y; sourceY < source.getHeight(); sourceY++, targetY++) {
              sourcePix = source.getPixel(sourceX,sourceY);
              targetPix = target.getPixel(targetX, targetY);
              int avg = (sourcePix.getRed() + sourcePix.getGreen() + sourcePix.getBlue()) / 3;
              targetPix.setColor(new Color(avg,avg,avg));
          }
      }
  }
  public static void sepia(Picture source, Picture target, int x, int y) {
      Pixel sourcePix = null;
      Pixel targetPix = null;
      //loop thru the columns (targetX is the starting point on Canvas)
      for (int sourceX = 0, targetX = x; sourceX < source.getWidth(); sourceX++, targetX++) {
          //loop thru the rows
          for (int sourceY = 0, targetY = y; sourceY < source.getHeight(); sourceY++, targetY++) {
              sourcePix = source.getPixel(sourceX,sourceY);
              targetPix = target.getPixel(targetX, targetY);
              int r = Math.min((int)(sourcePix.getRed() * .393) + (int)(sourcePix.getGreen() *.769) + (int)(sourcePix.getBlue() * .189), 255);
              int g = Math.min((int)(sourcePix.getRed() * .349) + (int)(sourcePix.getGreen() *.686) + (int)(sourcePix.getBlue() * .168), 255);
              int b = Math.min((int)(sourcePix.getRed() * .272) + (int)(sourcePix.getGreen() *.534) + (int)(sourcePix.getBlue() * .131), 255);
              targetPix.setColor(new Color(r,g,b));
          }
      }
  }
  public static void darken(Picture source, Picture target, int x, int y, int scale) {
      Pixel sourcePix = null;
      Pixel targetPix = null;
      //loop thru the columns (targetX is the starting point on Canvas)
      for (int sourceX = 0, targetX = x; sourceX < source.getWidth(); sourceX++, targetX++) {
          //loop thru the rows
          for (int sourceY = 0, targetY = y; sourceY < source.getHeight(); sourceY++, targetY++) {
              sourcePix = source.getPixel(sourceX,sourceY);
              targetPix = target.getPixel(targetX, targetY);
              int r = sourcePix.getRed() / scale;
              int g = sourcePix.getGreen() / scale;
              int b = sourcePix.getBlue() / scale;
              targetPix.setColor(new Color(r,g,b));
          }
      }
  }
  public static void brighten(Picture source, Picture target, int x, int y, int scale) {
      Pixel sourcePix = null;
      Pixel targetPix = null;
      //loop thru the columns (targetX is the starting point on Canvas)
      for (int sourceX = 0, targetX = x; sourceX < source.getWidth(); sourceX++, targetX++) {
          //loop thru the rows
          for (int sourceY = 0, targetY = y; sourceY < source.getHeight(); sourceY++, targetY++) {
              sourcePix = source.getPixel(sourceX,sourceY);
              targetPix = target.getPixel(targetX, targetY);
              int r = Math.min(sourcePix.getRed() * scale, 255);
              int g = Math.min(sourcePix.getGreen() * scale, 255);
              int b = Math.min(sourcePix.getBlue() * scale, 255);
              targetPix.setColor(new Color(r,g,b));
          }
      }
  }
  /**
   * add two ints to params and place you want target to go onto the canvas
   */
  public static void copytoCanvas(Picture source, Picture target, int x, int y) {
      Pixel sourcePix = null;
      Pixel targetPix = null;
    
      //loop thru the columns (targetX is the starting point on Canvas)
      for (int sourceX = 0, targetX = x; sourceX < source.getWidth(); sourceX++, targetX++) {
          //loop thru the rows
          for (int sourceY = 0, targetY = y; sourceY < source.getHeight(); sourceY++, targetY++) {
              sourcePix = source.getPixel(sourceX,sourceY);
              targetPix = target.getPixel(targetX, targetY);
              targetPix.setColor(sourcePix.getColor());
          }
      }
  }
  public static void shepherdFairy(Picture target, int x, int y) {
    Picture me = new Picture("images/extreme.jpg");
      
      Pixel[] pixels;
    pixels = me.getPixels();
    
     int red;
     int green;
     int blue;
     int avg;
    
    int bucketsize = pixels.length / 4;
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
    
    copytoCanvas(me, canvas, x, y);
  }
  public static int sum(Pixel px) { return px.getRed() + px.getBlue() + px.getGreen(); }
}//class
