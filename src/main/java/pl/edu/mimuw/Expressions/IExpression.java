package pl.edu.mimuw.Expressions;

public interface IExpression {
  int length();

  char charAt(int index);

  IExpression concat(IExpression other);
}
