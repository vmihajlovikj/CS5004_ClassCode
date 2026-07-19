package model.operations;

import model.Image;
import model.ImageImpl;
import model.Pixel;
import model.PixelImpl;

public class RedComponent implements ImageOperation {
  @Override
  public Image run(Image image) {
    Pixel [][] newPixels = new Pixel[image.getWidth()][image.getHeight()];

    for (int i = 0; i < image.getWidth(); i++) {
      for (int j = 0; j < image.getHeight(); j++) {
        Pixel originalPixel = image.getPixel(i,j);
        Pixel redCompnentPixel = new PixelImpl(originalPixel.getRed(),
                                                originalPixel.getRed(),
                                                originalPixel.getRed());
        newPixels[i][j] = redCompnentPixel;
      }
    }
    Image newImage = new ImageImpl(newPixels, image.getMaxValue() );
    //23 35 45 => 23 23 23
    return newImage;
  }
}
