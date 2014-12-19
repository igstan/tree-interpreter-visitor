package bjug.value;

import bjug.node.Node;

public class FunValue implements Value {
  public final String param;
  public final Node body;

  public FunValue(String param, Node body) {
    this.param = param;
    this.body = body;
  }

  @Override
  public <R> R accept(ValueVisitor<R> visitor) {
    return visitor.visit(this);
  }
}
