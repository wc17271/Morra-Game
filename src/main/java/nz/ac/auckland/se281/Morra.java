package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  // Global Variables:
  private boolean gameStarted = false;
  private Difficulty difficulty;
  private String user;
  private int pointsToWin;
  private int roundNumber;
  private int userWins;
  private int aiWins;
  private List<Integer> userFingerHistory = new ArrayList<>();

  protected Morra() {}

  // When newGame is executed, we must reset all global variables/clean slate
  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {

    // Initializing Variables:
    this.gameStarted = true;
    this.difficulty = difficulty;
    this.user = options[0];
    this.pointsToWin = pointsToWin;
    this.roundNumber = 1;
    this.userWins = 0;
    this.aiWins = 0;
    this.userFingerHistory.clear();

    MessageCli.WELCOME_PLAYER.printMessage(user);
  }

  public void play() {

    // Check if game has been started:
    if (gameStarted == false) {
      MessageCli.GAME_NOT_STARTED.printMessage();

      return;
    }

    // Print round number headers and get human inputs:
    MessageCli.START_ROUND.printMessage(Integer.toString(roundNumber));

    Human human = new Human();
    List<Integer> list = human.play();

    int humanFingers = list.get(0);
    int humanSum = list.get(1);

    // Get AI move:
    Jarvis jarvis = JarvisFactory.createJarvis(difficulty, userFingerHistory);
    int aiFingers = jarvis.getFingers();
    int aiSum = jarvis.getSum(aiFingers);

    // Store player's move AFTER ai's move so that it can't see its current hand:
    userFingerHistory.add(humanFingers);

    // Print player move:
    MessageCli.PRINT_INFO_HAND.printMessage(
        user, Integer.toString(humanFingers), Integer.toString(humanSum));

    // Print AI move:
    MessageCli.PRINT_INFO_HAND.printMessage(
        "Jarvis", Integer.toString(aiFingers), Integer.toString(aiSum));

    // Do checks to see who is winner and print result:
    int sum = humanFingers + aiFingers;

    if ((sum != humanSum && sum != aiSum) || (sum == humanSum && sum == aiSum)) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");

    } else if (sum == humanSum) { // human wins:
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");

      userWins++;

    } else if (sum == aiSum) { // ai wins:
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");

      aiWins++;
    }

    // check if game is finished:
    if (userWins == pointsToWin || aiWins == pointsToWin) {

      // check who the winner is:
      if (userWins == pointsToWin) {
        MessageCli.END_GAME.printMessage(user, Integer.toString(roundNumber));

        gameStarted = false;
      }

      if (aiWins == pointsToWin) {
        MessageCli.END_GAME.printMessage("Jarvis", Integer.toString(roundNumber));

        gameStarted = false;
      }
    }

    // if game not finished, increment round number:
    roundNumber++;
  }

  public void showStats() {
    // Check if game has been started:
    if (gameStarted == false) {
      MessageCli.GAME_NOT_STARTED.printMessage();

      return;
    }

    // if started, display game statistics:
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        user, Integer.toString(userWins), Integer.toString(pointsToWin - userWins));

    MessageCli.PRINT_PLAYER_WINS.printMessage(
        "Jarvis", Integer.toString(aiWins), Integer.toString(pointsToWin - aiWins));
  }
}
