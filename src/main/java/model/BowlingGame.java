package model;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private List<Frame> _frames = new ArrayList<Frame>();


    public int getCurrentScore() {
        int score = 0;
        for(Frame frame : _frames) {
            score += frame.getScore();
        }
        return score;
    }

    public List<Frame> getFrames() {
        return _frames;
    }

    public void addFrame(Frame frame) {
        if(frame.isIncomplete()) return;
        _frames.add(frame);
        int index = _frames.indexOf(frame);
        updateFramesBefore(index);
    }

    public void updateFramesBefore(int index) {
        Frame frame = _frames.get(index);
        switch(index) {
            case 0:
                break;
            case 1:
                _frames.get(0).addScoreFromFrame(frame,true);
                break;
            default:
                if(_frames.get(index-1).isSpare() || _frames.get(index-1).isStrike()){
                    _frames.get(index-1).addScoreFromFrame(frame,true);
                }
                if(_frames.get(index-2).isStrike() && _frames.get(index-1).isStrike()){
                    _frames.get(index-2).addScoreFromFrame(frame,false);
                }
                break;
        }
    }

}
