package model;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.StringReader;
import model.operations.ImageOperation;
import model.operations.RedComponent;
import org.junit.Test;

public class ImageImplTest {

  @Test
  public void testRedComponent(){
    StringReader reader = new StringReader("P3\n" +
                                              "2 2\n" +
                                              "255\n" +
                                              "12 23 34 45 45 56\n" +
                                              " 34 45 56 78 89 90");

    StringBuilder builder = new StringBuilder();

    ImageLoader ppmImageLoader = new PPMIMageLoader(reader);
    Image koala = ppmImageLoader.loadImage();
    ImageOperation redComponent = new RedComponent();
    Image redComponentKoala = redComponent.run(koala);
    ImageWriter imageWriter(builder);

    assertEquals("P3\n" +
                "2 2\n" +
                "255\n" +
                "12 12 12 45 45 45\n" +
                "34 34 34 78 78 78", builder.toString());

  }

}