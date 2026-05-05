
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
    static Picture canvas = new Picture("images\\7inX95in.jpg");
    /**
     * main method, to test the picture
     *
     */
  public static void main(String[] args)
  {
      //opens picture using a dialog box
      /*
     String fileName = FileChooser.pickAFile();
     Picture pictObj = new Picture(fileName);
     pictObj.explore();*/

     //opens a pictue using a path
     //Picture apic = new Picture("C:\\Users\\khayes\\Favorites\\Documents\APCS- Java\chap03\Curriclum 2013\Picture Color labs\images\\beach.jpg");
     
     
     //relative path             dir/folder/file
     
     //Picture ferris1 = new Picture("images/2000 ferris wheel2.jpg");
     //Picture moto = new Picture("images/blueMotorcycle.jpg");
     //Picture ferris3 = new Picture("images/2000 ferris wheel2.jpg");

     //temple.explore();
     //fix(temple);
     //temple.explore();//!!!!!!!!!!!!!!!!!!!!!!!!!displays the picture
     apic.explore();
     copytoCanvas(apic, canvas, 0, 0);
     canvas.explore();
     copytoCanvas(apic, canvas, 240, 0);
     //ferris1.explore();
     //moto.explore();
     
     //to change color of pic get all of the pixels!!!!111 😂✌️
     //makes an array of pixels
     Pixel[] pixels;
     //gets pixels from picture and assigns to pixels array
     //pixels = ferris1.getPixels();
    
     //how many pixels or how large array
    //System.out.println("This is a large array"+pixels.length  );


    /**/
        //access each index, array note
    //System.out.println(pixels[17]);
    //access each pixel pic.method.getPixel
    //Pixel spot = ferris1.getPixel(100,100);
    //Pixel spot50 = ferris1.getPixel(50, 50);
    Color ltsteel = new Color(176,196,222);
    
    //System.out.println(pixels[17].getColor());
    //System.out.println(spot);
    
    //Pixel spot17 = pixels[17];
    //spot17.setRed(200);
    //spot17.setBlue(150);
    //spot17.setGreen(175);
    
    
    //spot.setColor(Color.yellow);
    //spot50.setColor(ltsteel);
    //ferris1.explore();
/*
    pixels[17].setColor(Color.blue);
    spot.setColor(new Color(252,252,252));
    pixels[500034].setColor(Color.blue);

    ferris1.explore();
/*
   // loop to access indexes of array or collection

    //for each loop spot  is a ?
    for (Pixel spot : pixels)
    System.out.println( spot );


   
 /**/

 /**
  * Method to clear red from picture
  * @param none
  * @return none
  */
 /*
    for (Pixel pixelObj : pixels)
        {
            //set the red value of the current pixel to the new value
           

        }
    ferris1.explore();
    
/**/
 /**
  * Method to reduce red from picture by a factor of n
  * @param none
  * @return none
  */

/*
int value;
final double  FACTOR = .5;
    for (Pixel pixelObj : pixels)
    {

        //get the redvalue
        value = pixelObj.getRed();
        //System.out.println(value);

        //decrease the red value by 50%
        
        //set the red value of the current pixel to the new value
        

    }
    // use new picture when changing or it will make changes to 
    // pic you already changed
    ferris1.explore();
    ferris2.explore();

  /**/ 
    //write/save a picture as a file
    //ferris1.write("images/ferris11.jpg");

    /**/
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
  /**
   * Method to mirror around a vertical line in the middle of the
   * picture based on the width
   */
  public static void mirrorVertical() {
      int width = apic.getWidth();
      int mirrorPoint = 267;
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      
      //loop through all the rows
      for (int y = 0; y < apic.getHeight(); y++) {
          //loop from 0 to the middle (mirror point)
          for (int x = 0; x < mirrorPoint; x++) {
              leftPixel = apic.getPixel(x,y);
              rightPixel = apic.getPixel(width - 1 -x, y);
              rightPixel.setColor(leftPixel.getColor());
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
}//class
