package model;


public class FinalFrame extends Frame{
    private final int MAX_THROWS = 3;

    @Override
    public void updateStatus() {
        int size = getBallThrowScores().size();
        switch (size) {
            case 1:
                setStatus(FrameStatus.INCOMPLETE);
                break;
            case 2:
                if(getBallThrowScores().get(0) == MAX_SCORE_IN_A_THROW){
                    setStatus(FrameStatus.INCOMPLETE);
                } else if(getBallThrowScores().get(0) + getBallThrowScores().get(1) == MAX_SCORE_IN_A_THROW) {
                    setStatus(FrameStatus.INCOMPLETE);
                } else {
                    setStatus(FrameStatus.FINAL);
                }
                break;
            case MAX_THROWS:
                setStatus(FrameStatus.FINAL);
                break;
            default:
                setStatus(FrameStatus.FINAL);
        }
    }

    @Override
    public int scoreCanBeUsedByOtherFrame() {
        if(getBallThrowScores().size() <= 2) return getScore();
        return getBallThrowScores().get(0) + getBallThrowScores().get(1);
    }

}
