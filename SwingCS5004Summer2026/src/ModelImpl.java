import java.util.Objects;

public class ModelImpl implements Model {
  private String data;

  public ModelImpl(String data) {
    this.data = Objects.requireNonNull(data);
  }

  @Override
  public void saveData(String data) {
    this.data = Objects.requireNonNull(data);
  }

  @Override
  public String loadData() {
    return this.data;
  }
}
