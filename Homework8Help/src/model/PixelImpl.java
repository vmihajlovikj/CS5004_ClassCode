package model;

public class PixelImpl implements Pixel {
  private final int red;
  private final int green;
  private final int blue;
  private final int higherBound = 255;
  public PixelImpl(int red, int green, int blue) {
    if ( red < 0 || green < 0 || blue < 0 || red > higherBound || green > higherBound || blue > higherBound ) {
      throw new IllegalArgumentException("Red, green, blue is negative or > " + higherBound);
    }
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  @Override
  public int getRed() {
    return this.red;
  }

  @Override
  public int getGreen() {
    return this.green;
  }

  @Override
  public int getBlue() {
    return this.blue;
  }
}
