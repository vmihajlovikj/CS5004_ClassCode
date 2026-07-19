package model;

public class PPMWriter implements ImageWriter {
  private Appendable out;
  public PPMWriter(Appendable out) {
    if ( out == null) {
      throw new IllegalArgumentException("out == null");
    }

    this.out = out;
  }

  @Override
  public void writeImage(Image image) {
    //Write out the in PPM format to the appendable.
  }
}
