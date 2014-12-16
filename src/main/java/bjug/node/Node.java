package bjug.node;

public interface Node {
  public <R> R accept(NodeVisitor<R> visitor);
}
