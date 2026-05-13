Here's how I transformed the original image in my collage project:

-recursive shrink - shrunk the image by skipping half of the pixels, then made sure to call the method again and sending it the shrink factor. once the shrink factor got to a certain threshold, it stopped shrinking
-negate - subtracted each of the color values from 255
-grayscale - found each pixel, found the average of the r, g, b values, then set each of those r, g, b values to the average
-sheperd fairey - each pixel falls into a range of preset colors, then that color is applied to that pixel
-brighten - multiply pixel r, g, b values by a passed in scale factor, clamped to 255
-darken - divide pixel r, g, b values by a passed in scale factor
-mirror vertical - takes the pixels from the top half of the image and moves them to the bottom half, the same distance away from the middle
-sepia - r, g, b values are found by calculating preset values: 
red = Math.min((int)(sourcePix.getRed() * .393) + (int)(sourcePix.getGreen() *.769) + (int)(sourcePix.getBlue() * .189), 255);
green = Math.min((int)(sourcePix.getRed() * .349) + (int)(sourcePix.getGreen() *.686) + (int)(sourcePix.getBlue() * .168), 255);
blue = Math.min((int)(sourcePix.getRed() * .272) + (int)(sourcePix.getGreen() *.534) + (int)(sourcePix.getBlue() * .131), 255);