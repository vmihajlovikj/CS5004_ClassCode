package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PPMIMageLoader implements ImageLoader {
  private final Readable readable;

  public PPMIMageLoader(Readable readable) {
    if ( readable == null ) {
      throw new IllegalArgumentException("readable is null");

    }
    this.readable = readable;
  }


  @Override
  public Image loadImage() {
    Scanner sc = new Scanner( this.readable );

    StringBuilder builder = new StringBuilder();
    //read the file line by line, and populate a string. This will throw away any comment lines
    while (sc.hasNextLine()) {
      String s = sc.nextLine();//the first line.
      if (s.charAt(0) != '#') {
        builder.append(s + System.lineSeparator());
      }
    }

    //now set up the scanner to read from the string we just built
    sc = new Scanner(builder.toString());

    String token;

    token = sc.next();
    if (!token.equals("P3")) {
      throw new IllegalStateException("Invalid PPM file: plain RAW file should begin with P3");
    }
    int columns = sc.nextInt();
    int rows =  sc.nextInt();
    int maxValue = sc.nextInt();


    Pixel[][] pixels = new Pixel[rows][columns];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();
        Pixel pixel = new PixelImpl(r, g, b);
        pixels[i][j] = pixel;

      }
    }
    return new ImageImpl(pixels, maxValue);
  }
}
