package bjug;

import bjug.node.Add;
import bjug.node.Fun;
import bjug.node.Node;
import bjug.node.NodeVisitor;
import bjug.node.Num;

public class JsCompiler implements NodeVisitor<String> {

  public static void main(String[] args) {
    JsCompiler jsCompiler = new JsCompiler();
    Node program = new Fun("p", new Add(new Num(1), new Num(2)));
    String result = program.accept(jsCompiler);
    System.out.println("result: " + result);
  }

  @Override
  public String visit(Num n) {
    return Integer.toString(n.value);
  }

  @Override
  public String visit(Add a) {
    String left = a.left.accept(this);
    String right = a.right.accept(this);
    return String.format("%s + %s", left, right);
  }

  @Override
  public String visit(Fun fun) {
    String param = fun.param;
    String body = fun.body.accept(this);
    return String.format("function (%s) { return %s; }", param, body);
  }
}
