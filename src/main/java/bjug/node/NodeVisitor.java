package bjug.node;

public interface NodeVisitor<R> {
  public R visit(Num n);
  public R visit(Add a);
  public R visit(Fun fun);
}
