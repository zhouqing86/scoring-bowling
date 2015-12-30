package model;

import junit.framework.TestCase;

public class FrameTest extends TestCase {

  private Frame frame = null;

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    frame = new Frame();
  }

  public void testScoreWithTwoThrows() {
    frame.throwABall(1);
    assertEquals(1, frame.getBallThrows().size());
    assertEquals(1, frame.getScore());
    frame.throwABall(5);
    assertEquals(2, frame.getBallThrows().size());
    assertEquals(6, frame.getScore());
  }

  @Override
  protected void tearDown() throws Exception {
    super.tearDown();
    frame = null;
  }
}
