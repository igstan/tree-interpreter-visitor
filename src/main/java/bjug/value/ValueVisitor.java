package bjug.value;

public interface ValueVisitor<T> {
  public T visitNumValue(NumValue num);
  public T visitFunValue(FunValue fun);
}
