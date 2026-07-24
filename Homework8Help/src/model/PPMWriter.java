package model;

import java.io.IOException;

public class PPMWriter implements ImageWriter {
  private Appendable out;
  public PPMWriter(Appendable out) {
    if ( out == null) {
      throw new IllegalArgumentException("out == null");
    }

    this.out = out;
  }

  void write(String message){
    try{
      this.out.append(message);
    }catch(IOException e){
      throw new IllegalStateException("Appendable failed.");
    }
  }

  @Override
  public void writeImage(Image image) {
    write("P3\n");
    write(String.format("%d %d\n", image.getWidth(), image.getHeight()));

    for ( int i = 0; i < image.getHeight();  i++ ) {
      for ( int j = 0; j < image.getWidth(); j++ ) {
          write(image.getPixel(i, j).toString() + " ");
      }
      write("\n");
    }
  }
}
