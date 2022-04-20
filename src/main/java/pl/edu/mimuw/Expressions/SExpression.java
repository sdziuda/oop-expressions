package pl.edu.mimuw.Expressions;

import java.util.ArrayList;
import java.util.List;

public class SExpression implements IExpression {
  private final List<String> expression;
  private final List<Integer> sumPref;

  public SExpression(List<String> expression) {
    this.expression = expression;
    this.sumPref = new ArrayList<>();
    this.sumPref.add(0);
    for (var ss : expression) {
      this.sumPref.add(this.sumPref.get(this.sumPref.size() - 1) + ss.length());
    }
  }

  public int length() {
    return this.sumPref.get(this.sumPref.size() - 1);
  }

  public char charAt(int index) {
    if (index < 0 || index >= this.length()) {
      throw new IndexOutOfBoundsException();
    }

    int left = 0;
    int right = this.expression.size() - 1;
    int middle;
    while (left < right) {
      middle = (left + right) / 2;
      if (this.sumPref.get(middle) <= index) {
        left = middle;
      } else {
        right = middle - 1;
      }
    }

    return this.expression.get(left).charAt(index - this.sumPref.get(left));
  }

  public IExpression concat(IExpression expression) {
    final var newExpression = new ArrayList<>(this.expression);

    var otherExpression = new char[expression.length()];
    for (int i = 0; i < expression.length(); i++) {
      otherExpression[i] = expression.charAt(i);
    }

    newExpression.add(new String(otherExpression));

    return new SExpression(newExpression);
  }
}
