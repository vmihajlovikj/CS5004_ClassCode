import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Objects;

public class ControllerImpl implements Controller, ViewEventHandler {
  private final View view;
  private final Model model;

  public ControllerImpl(View view, Model model) {
    this.view = Objects.requireNonNull(view, "view must not be null");
    this.model = Objects.requireNonNull(model, "model must not be null");
    this.view.addViewListener(this); //subscription
  }

  @Override
  public void run() {

  }

  public void handleLoadRequest() {
    String textFromModel = model.loadData();
    view.displayText(textFromModel + "\n");
  }

  public void handleSaveRequest() {
    String textInView = view.getText();
    model.saveData(textInView);
  }
}
