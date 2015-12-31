import model.BowlingGame;

public class ScoringBowling {

  public static void main(String []args) {
    String [] gameScore = "1 2 3 4".split(" ");
    BowlingGame game = new BowlingGame();
    for(String aThrow : gameScore) {
      game.throwABall(Integer.parseInt(aThrow));
    }
    System.out.println(game.getCurrentScore());

    gameScore = "9 1 9 1".split(" ");
    game = new BowlingGame();
    for(String aThrow : gameScore) {
      game.throwABall(Integer.parseInt(aThrow));
    }
    System.out.println(game.getCurrentScore());

    gameScore = "1 1 1 1 10 1 1".split(" ");
    game = new BowlingGame();
    for(String aThrow : gameScore) {
      game.throwABall(Integer.parseInt(aThrow));
    }
    System.out.println(game.getCurrentScore());

    gameScore = "10 10 10 10 10 10 10 10 10 10 10 10".split(" ");
    game = new BowlingGame();
    for(String aThrow : gameScore) {
      game.throwABall(Integer.parseInt(aThrow));
    }
    System.out.println(game.getCurrentScore());

  }

}
