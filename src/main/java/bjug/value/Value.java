package bjug.value;

public interface Value {
  public <R> R accept(ValueVisitor<R> visitor);
}
