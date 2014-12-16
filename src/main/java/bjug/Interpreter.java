package bjug;

import bjug.node.Add;
import bjug.node.Fun;
import bjug.node.Node;
import bjug.node.NodeVisitor;
import bjug.node.Num;
import bjug.value.FunValue;
import bjug.value.NumValue;
import bjug.value.Value;
import bjug.value.ValueVisitor;

public class Interpreter implements NodeVisitor<Value> {

  public static void main(String[] args) {
    Interpreter interpreter = new Interpreter();
    Node program = new Add(new Num(1), new Num(2));
    Value result = program.accept(interpreter);

    String repr = result.accept(new ValueVisitor<String>() {
      @Override
      public String visitNumValue(NumValue num) {
        return Integer.toString(num.value);
      }

      @Override
      public String visitFunValue(FunValue fun) {
        return "[function]";
      }
    });

    System.out.println("result: " + repr);
  }

  @Override
  public Value visitNum(Num n) {
    return new NumValue(n.value);
  }

  @Override
  public Value visitAdd(Add a) {
    final Value left = a.left.accept(this);
    final Value right = a.right.accept(this);

    return left.accept(new ValueVisitor<Value>() {
      @Override
      public Value visitNumValue(final NumValue a) {
        return right.accept(new ValueVisitor<Value>() {
          @Override
          public Value visitNumValue(NumValue b) {
            return new NumValue(a.value + b.value);
          }

          @Override
          public Value visitFunValue(FunValue fun) {
            throw new RuntimeException("Second operand was not a number: function found.");
          }
        });
      }

      @Override
      public Value visitFunValue(FunValue fun) {
        throw new RuntimeException("First operand was not a number: function found.");
      }
    });
  }

  @Override
  public Value visitFun(Fun fun) {
    return new FunValue(fun.param, fun.body);
  }
}
