package view;

import java.io.IOException;
import java.io.OutputStream;

public class ViewImpl implements View {
  private final Appendable appendable;

  private void write(String message){
    try{
      appendable.append( message );
    }catch(IOException e){
      throw new IllegalStateException(e.getMessage());
    }
  }

  public ViewImpl(Appendable appendable) {
    if (appendable == null) {
      throw new NullPointerException("The output stream cannot be null.");
    }
    this.appendable = appendable;
  }

  public ViewImpl() {
    this(System.out);
  }

  @Override
  public void renderMessage(String message) {
    write(message);
  }
}
