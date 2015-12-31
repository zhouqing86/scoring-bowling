package model;

import junit.framework.TestCase;

public class FinalFrameTest extends TestCase {
    private FinalFrame frame = new FinalFrame();

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void  testScoreAndFrameStatusShouldBeNomalHitWithTwoNormalThrows() {
        frame.throwABall(1);
        assertEquals(1, frame.getBallThrowScores().size());
        assertEquals(1, frame.getScore());
        assertEquals(FrameStatus.INCOMPLETE, frame.getStatus());
        frame.throwABall(5);
        assertEquals(2, frame.getBallThrowScores().size());
        assertEquals(6, frame.getScore());
        assertEquals(FrameStatus.FINAL, frame.getStatus());
    }

    public void  testScoreAndFrameStatusShouldBeNomalHitWithStrikeThrows() {
        frame.throwABall(10);
        assertEquals(FrameStatus.INCOMPLETE, frame.getStatus());
        frame.throwABall(10);
        assertEquals(FrameStatus.INCOMPLETE, frame.getStatus());
        frame.throwABall(10);
        assertEquals(FrameStatus.FINAL, frame.getStatus());
        assertEquals(30, frame.getScore());
    }

    public void  testScoreAndFrameStatusShouldBeNomalHitWithSpareThrows() {
        frame.throwABall(1);
        assertEquals(FrameStatus.INCOMPLETE, frame.getStatus());
        frame.throwABall(9);
        assertEquals(FrameStatus.INCOMPLETE, frame.getStatus());
        frame.throwABall(10);
        assertEquals(FrameStatus.FINAL, frame.getStatus());
        assertEquals(20, frame.getScore());
    }

    public void testAddScoreFromNeighBorFinalFrameWhenStatusIsStrike() {
        Frame nextFrame = new Frame();
        nextFrame.throwABall(10);
        frame.throwABall(10);
        frame.throwABall(2);
        frame.throwABall(2);
        nextFrame.addScoreFromFrame(frame);
        assertEquals(22,nextFrame.getScore());
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        frame = null;
    }
}