package model;

import junit.framework.TestCase;

public class FrameTest extends TestCase {

  private Frame frame = null;

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    frame = new Frame();
  }

  public void testScoreAndFrameStatusShouldBeNomalHitWithTwoNormalThrows() {
    frame.throwABall(1);
    assertEquals(1, frame.getBallThrowScores().size());
    assertEquals(1, frame.getScore());
    assertEquals(FrameStatus.INCOMPLETE, frame.getStatus());
    frame.throwABall(5);
    assertEquals(2, frame.getBallThrowScores().size());
    assertEquals(6, frame.getScore());
    assertEquals(FrameStatus.NORMALHIT, frame.getStatus());
  }


  public void testScoreAndFrameStatusShouldBeNomalHitWithStrikeThrows() {
    frame.throwABall(10);
    assertEquals(1, frame.getBallThrowScores().size());
    assertEquals(10, frame.getScore());
    assertEquals(FrameStatus.STRIKE, frame.getStatus());;
  }

  public void testScoreAndFrameStatusShouldBeNomalHitWithSpareThrows() {
    frame.throwABall(1);
    assertEquals(1, frame.getBallThrowScores().size());
    assertEquals(1, frame.getScore());
    assertEquals(FrameStatus.INCOMPLETE, frame.getStatus());
    frame.throwABall(9);
    assertEquals(2, frame.getBallThrowScores().size());
    assertEquals(10, frame.getScore());
    assertEquals(FrameStatus.SPARE, frame.getStatus());
  }

  public void testAddScoreFromNeighBorFrameWhenStatusIsStrike() {
    frame.throwABall(10);
    Frame neigbor = new Frame();
    neigbor.throwABall(5);
    neigbor.throwABall(5);
    frame.addScoreFromFrame(neigbor,true);
    assertEquals(20,frame.getScore());
  }

  public void testAddScoreFromNotNeighBorFrameWhenStatusIsStrike() {
    frame.throwABall(10);
    Frame notNeighbor = new Frame();
    notNeighbor.throwABall(5);
    notNeighbor.throwABall(5);
    frame.addScoreFromFrame(notNeighbor,false);
    assertEquals(15,frame.getScore());
  }

  public void testAddScoreFromNeighBorFrameWhenStatusIsSpare() {
    frame.throwABall(5);
    frame.throwABall(5);
    Frame notNeighbor = new Frame();
    notNeighbor.throwABall(5);
    notNeighbor.throwABall(5);
    frame.addScoreFromFrame(notNeighbor,true);
    assertEquals(15,frame.getScore());
  }

  @Override
  protected void tearDown() throws Exception {
    super.tearDown();
    frame = null;
  }
}
