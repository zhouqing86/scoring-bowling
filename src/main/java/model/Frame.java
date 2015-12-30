package model;

import java.util.ArrayList;

public class Frame {

  private ArrayList<Integer> _ballThrows = new ArrayList<Integer>();
  private int MAX_SCORE_IN_A_THROW = 10;
  private int _score = 0;

  public int getScore() {
    return _score;
  }

  public void setScore(int score) {
    this._score = score;
  }

  public void throwABall(int score) {
    _ballThrows.add(score);
    _score += score;
  }

  public ArrayList<Integer> getBallThrows() {
    return _ballThrows;
  }

}
