package bjug.value;

public class NumValue implements Value {
  public final int value;

  public NumValue(int value) {
    this.value = value;
  }

  @Override
  public <R> R accept(ValueVisitor<R> visitor) {
    return visitor.visitNumValue(this);
  }
}
