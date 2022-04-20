package pl.edu.mimuw.Expressions;

import java.util.ArrayList;
import java.util.List;

public class CExpression implements IExpression{
  private final List<Character> chars;

  public CExpression(List<Character> chars){
    this.chars = chars;
  }

  public int length(){
    return chars.size();
  }

  public char charAt(int index){
    return chars.get(index);
  }

  public IExpression concat(IExpression other){
    final var newChars = new ArrayList<>(chars);

    for (int i = 0; i < other.length(); i++) {
      newChars.add(other.charAt(i));
    }

    return new CExpression(newChars);
  }
}
