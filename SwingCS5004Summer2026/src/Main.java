public class Main {
  public static void main(String[] args) {
    Model model = new ModelImpl("Starting data.");
    View view = new View();
    view.setVisible(true);

    Controller controller = new ControllerImpl(view, model);
    controller.run();

  }
}
