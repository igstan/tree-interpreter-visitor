package bjug.node;

public interface NodeVisitor<R> {
  public R visitNum(Num n);
  public R visitAdd(Add a);
  public R visitFun(Fun fun);
}
