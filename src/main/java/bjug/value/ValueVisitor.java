package bjug.value;

public interface ValueVisitor<T> {
  public T visit(NumValue num);
  public T visit(FunValue fun);
}
