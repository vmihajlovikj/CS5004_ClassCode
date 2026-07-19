package model;

public interface Image {
  int getWidth();
  int getHeight();
  int getMaxValue();
  Pixel getPixel(int x, int y);
}
