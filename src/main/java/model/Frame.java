package model;

import java.util.ArrayList;
import java.util.List;


public class Frame implements IFrame{

  private List<Integer> _ballThrowScores = new ArrayList<Integer>();
  private int _score = 0;
  private FrameStatus _status = FrameStatus.INCOMPLETE;

  protected final int MAX_SCORE_IN_A_THROW = 10;

  public void setStatus(FrameStatus _status) {
    this._status = _status;
  }

  public FrameStatus getStatus() {
    return _status;
  }

  public int getScore() {
    return _score;
  }

  public int scoreCanBeUsedByOtherFrame() {
    return getScore();
  }

  public List<Integer> getBallThrowScores() {
    return _ballThrowScores;
  }

  public void throwABall(int score) {
    _ballThrowScores.add(score);
    _score += score;
    updateStatus();
  }

  public void addScoreFromFrame(Frame frame, boolean isNeighborhood) {
    if(isNeighborhood && isStrike()) _score += frame.scoreCanBeUsedByOtherFrame();
    if(isNeighborhood && isSpare()) _score += frame.getBallThrowScores().get(0);
    if(!isNeighborhood && isStrike()) _score += frame.getBallThrowScores().get(0);
  }

  public void addScoreFromFrame(Frame nextFrame) {
     addScoreFromFrame(nextFrame,true);
  }


  public boolean isStrike(){
    return _status == FrameStatus.STRIKE;
  }

  public boolean isSpare() {
    return _status == FrameStatus.SPARE;
  }

  public boolean isNormalHit() {
    return _status == FrameStatus.NORMALHIT;
  }

  public boolean isIncomplete() {
    return _status == FrameStatus.INCOMPLETE;
  }

  public void updateStatus() {
    switch (_ballThrowScores.size()) {
      case 1:
        if(_ballThrowScores.get(0) == MAX_SCORE_IN_A_THROW) {
          _status = FrameStatus.STRIKE;
          return;
        }
        _status = FrameStatus.INCOMPLETE;
        break;
      case 2:
        if(_ballThrowScores.get(0) + _ballThrowScores.get(1) == MAX_SCORE_IN_A_THROW){
          _status = FrameStatus.SPARE;
          return;
        }
        _status = FrameStatus.NORMALHIT;
        break;
      default:
        _status = FrameStatus.NORMALHIT;
        break;
    }
  }



}
