package bjug.node;

public class Add implements Node {
  public final Node left, right;

  public Add(Node left, Node right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public <R> R accept(NodeVisitor<R> visitor) {
    return visitor.visit(this);
  }
}
