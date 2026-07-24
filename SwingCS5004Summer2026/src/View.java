import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class View extends JFrame implements ActionListener, KeyListener, MouseListener {
  private final JButton button1;
  private final JButton button2;
  private final JTextArea textArea;
  private ViewEventHandler viewEventHandler;
  public View() {
    super("Example Window");


    setSize(800, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setLayout( new  BorderLayout());

    button1 = new JButton("Load");
    button1.setActionCommand("loadButton");
    button1.addActionListener(this);

    button2 = new JButton("Save");
    button2.setActionCommand("saveButton");
    button2.addActionListener(this);

    this.addKeyListener(this);
    this.addMouseListener(this);

    textArea = new JTextArea();

    add(button1,  BorderLayout.NORTH);
    add(textArea,   BorderLayout.CENTER);
    add(button2,  BorderLayout.SOUTH);
  }


  public void displayText(String text){
    textArea.setText(text);
  }
  public String getText(){
    return textArea.getText();
  }

  public void addViewListener(ViewEventHandler eventHandler){
    this.viewEventHandler = Objects.requireNonNull(eventHandler);
  }

  /**
   * Invoked when an action occurs.
   *
   * @param e the event to be processed
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    switch(e.getActionCommand()){
      case "loadButton":
        this.viewEventHandler.handleLoadRequest(); //notifies the listener

        break;
        case "saveButton":
          this.viewEventHandler.handleSaveRequest();
          break;
    }
  }

  /**
   * Invoked when a key has been typed.
   * See the class description for {@link KeyEvent} for a definition of
   * a key typed event.
   *
   * @param e the event to be processed
   */
  @Override
  public void keyTyped(KeyEvent e) {
   //  if(e.getKeyChar() == KeyEvent.C){}
  }

  /**
   * Invoked when a key has been pressed.
   * See the class description for {@link KeyEvent} for a definition of
   * a key pressed event.
   *
   * @param e the event to be processed
   */
  @Override
  public void keyPressed(KeyEvent e) {

  }

  /**
   * Invoked when a key has been released.
   * See the class description for {@link KeyEvent} for a definition of
   * a key released event.
   *
   * @param e the event to be processed
   */
  @Override
  public void keyReleased(KeyEvent e) {

  }

  /**
   * Invoked when the mouse button has been clicked (pressed
   * and released) on a component.
   *
   * @param e the event to be processed
   */
  @Override
  public void mouseClicked(MouseEvent e) {

  }

  /**
   * Invoked when a mouse button has been pressed on a component.
   *
   * @param e the event to be processed
   */
  @Override
  public void mousePressed(MouseEvent e) {

  }

  /**
   * Invoked when a mouse button has been released on a component.
   *
   * @param e the event to be processed
   */
  @Override
  public void mouseReleased(MouseEvent e) {

  }

  /**
   * Invoked when the mouse enters a component.
   *
   * @param e the event to be processed
   */
  @Override
  public void mouseEntered(MouseEvent e) {

  }

  /**
   * Invoked when the mouse exits a component.
   *
   * @param e the event to be processed
   */
  @Override
  public void mouseExited(MouseEvent e) {

  }
}
