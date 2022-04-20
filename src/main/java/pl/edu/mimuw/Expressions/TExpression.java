package pl.edu.mimuw.Expressions;

public class TExpression implements IExpression {
  private final char[] expression;

  public TExpression(char[] expression) {
    this.expression = new char[expression.length];
    System.arraycopy(expression, 0, this.expression, 0, expression.length);
  }

  public int length() {
    return this.expression.length;
  }

  public char charAt(int index) {
    if (index < 0 || index >= this.length()) {
      throw new IndexOutOfBoundsException();
    }
    return this.expression[index];
  }

  public IExpression concat(IExpression expression) {
    var result = new char[this.expression.length + expression.length()];

    System.arraycopy(this.expression, 0, result, 0, this.length());

    for (int i = 0; i < expression.length(); i++) {
      result[this.length() + i] = expression.charAt(i);
    }

    return new TExpression(result);
  }
}
