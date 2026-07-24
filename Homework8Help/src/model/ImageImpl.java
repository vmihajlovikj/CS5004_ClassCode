package model;

import java.awt.geom.Point2D;
import java.util.Arrays;

public class ImageImpl implements Image {
  private final int width;
  private final int height;
  private final Pixel[][] pixels;
  private final int maxValue;

  public ImageImpl(Pixel[][] pixels, int maxValue) {
    if ( pixels == null ){
      throw new IllegalArgumentException("Pixels cannot be null");
    }
    this.width = pixels[0].length;
    this.height = pixels.length;
    this.maxValue = maxValue;

    this.pixels = new  Pixel[this.height][this.width];

    for ( int i = 0; i < this.height; i++ ){
      for ( int j = 0; j < this.width; j++ ){
        this.pixels[i][j] = pixels[i][j];
      }
    }
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public int getMaxValue() {
    return maxValue;
  }

  @Override
  public Pixel getPixel(int x, int y) {
    if ( x < 0 || y < 0 || x >= height || y >= width) {
      throw new IllegalArgumentException("x=" + x + " y=" + y);
    }
    return this.pixels[x][y];
  }
}
