package controller.commands;

import java.util.function.Supplier;

public class LoadCommandSupplier implements Supplier<Command> {
  /**
   * Gets a result.
   *
   * @return a result
   */
  @Override
  public Command get() {
    return new LoadCommand();
  }
}
