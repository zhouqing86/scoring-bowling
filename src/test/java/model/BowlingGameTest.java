package model;

import junit.framework.TestCase;
import org.easymock.EasyMock;


public class BowlingGameTest extends TestCase {

    private BowlingGame game = null;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        game = new BowlingGame();
    }

    public void testDontAddFrameWhenFrameIsIncomplete(){
        Frame frame2  = new Frame();
        game.addFrame(frame2);
        assertEquals(0,game.getFrames().size());
    }

    public void testAddFrameWhenFrameIsNotIncomplete() {
        Frame frame2  = new Frame();
        frame2.throwABall(10);
        Frame frame3  = new Frame();
        frame3.throwABall(9);
        frame3.throwABall(1);
        Frame frame4  = new Frame();
        frame4.throwABall(3);
        frame4.throwABall(2);
        game.addFrame(frame2);
        game.addFrame(frame3);
        game.addFrame(frame4);
        assertEquals(3,game.getFrames().size());
    }

    public void testGetScorcesFromIncompleteGame(){
        Frame frame2  = new Frame();
        frame2.throwABall(10);
        Frame frame3  = new Frame();
        frame3.throwABall(9);
        frame3.throwABall(1);
        Frame frame4  = new Frame();
        frame4.throwABall(3);
        frame4.throwABall(2);
        game.addFrame(frame2);
        game.addFrame(frame3);
        game.addFrame(frame4);
        assertEquals(38, game.getCurrentScore());
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        game = null;
    }
}