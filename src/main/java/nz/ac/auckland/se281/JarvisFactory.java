package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Difficulty;

// Creates instances of the game mode depending on user input:
public class JarvisFactory {

  // creates new instances of the game difficulty - easy, medium, hard and master
  public static Jarvis createJarvis(Difficulty difficulty, List<Integer> userFingerHistory) {

    // switch case to return the correct game mode instance:
    switch (difficulty) {
      case EASY:
        return new EasyDifficulty();

      case MEDIUM:
        return new MediumDifficulty(userFingerHistory);

      case HARD:
        return new HardDifficulty(userFingerHistory);

      case MASTER:
        return new MasterDifficulty(userFingerHistory);

      default:
        return null;
    }
  }
}
