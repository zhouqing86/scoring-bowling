package model;

import java.util.ArrayList;
import java.util.List;


public class Frame {

  private List<Integer> _ballThrowScores = new ArrayList<Integer>();
  private final int MAX_SCORE_IN_A_FRAME = 10;
  private int _score = 0;
  private FrameStatus _status = FrameStatus.INCOMPLETE;
  private int recordedThrows = 0;

  public void setStatus(FrameStatus _status) {
    this._status = _status;
  }

  public FrameStatus getStatus() {
    return _status;
  }

  public int getRecordedThrows() {
    return recordedThrows;
  }

  public int getScore() {
    return _score;
  }

  public List<Integer> getBallThrowScores() {
    return _ballThrowScores;
  }

  public void throwABall(int score) {
    _ballThrowScores.add(score);
    _score += score;
    updateStatusAndThrows();
  }

  public void addScoreFromFrame(Frame frame, boolean isNeighborhood) {
    if(isNeighborhood && isStrike()) _score += frame.getScore();
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

  private void updateStatusAndThrows() {
    switch (_ballThrowScores.size()) {
      case 1:
        recordedThrows = 1;
        if(_ballThrowScores.get(0) == MAX_SCORE_IN_A_FRAME) {
          _status = FrameStatus.STRIKE;
          return;
        }
        _status = FrameStatus.INCOMPLETE;
        break;
      case 2:
        recordedThrows = 2;
        if(_ballThrowScores.get(0) + _ballThrowScores.get(1) == MAX_SCORE_IN_A_FRAME){
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
