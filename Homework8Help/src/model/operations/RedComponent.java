package model.operations;

import model.Image;
import model.ImageImpl;
import model.Pixel;
import model.PixelImpl;

public class RedComponent implements ImageOperation {
  @Override
  public Image run(Image image) {
    Pixel [][] newPixels = new Pixel[image.getHeight()][image.getWidth()];

    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        Pixel originalPixel = image.getPixel(i,j);
        Pixel redCompnentPixel = new PixelImpl(originalPixel.getRed(),
                                                originalPixel.getRed(),
                                                originalPixel.getRed());
        newPixels[i][j] = redCompnentPixel;
      }
    }
    return new ImageImpl(newPixels, image.getMaxValue() );
  }
}
