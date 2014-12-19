package bjug.node;

public class Fun implements Node {
  public final String param;
  public final Node body;

  public Fun(String param, Node body) {
    this.param = param;
    this.body = body;
  }

  @Override
  public <R> R accept(NodeVisitor<R> visitor) {
    return visitor.visit(this);
  }
}
