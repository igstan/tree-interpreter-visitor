package bjug.node;

public class Num implements Node {
  public final int value;

  public Num(int value) {
    this.value = value;
  }

  @Override
  public <R> R accept(NodeVisitor<R> visitor) {
    return visitor.visit(this);
  }
}
