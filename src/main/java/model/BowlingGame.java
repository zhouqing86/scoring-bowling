package model;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private List<Frame> _frames = new ArrayList<Frame>();
    protected final int MAX_FRAME = 10;


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
        _frames.add(frame);
        int index = _frames.indexOf(frame);
        updateFramesBefore(index);
    }

    public void updateFramesBefore(int index) {
        Frame frame = _frames.get(index);
        if(frame.isIncomplete()) return;
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

    public void throwABall(int aThrow) {
        int size = _frames.size();
        if(size == 0) {
            Frame frame = new Frame();
            frame.throwABall(aThrow);
            addFrame(frame);
            return;
        }
        if(_frames.get(size-1).isIncomplete()) {
            _frames.get(size-1).throwABall(aThrow);
            updateFramesBefore(size-1);
        } else {
            Frame frame = null;
            if(size == MAX_FRAME-1) {
                frame = new FinalFrame();
            } else {
                frame = new Frame();
            }
            frame.throwABall(aThrow);
            addFrame(frame);
        }
    }

}
