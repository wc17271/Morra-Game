package nz.ac.auckland.se281;

import java.util.List;

public class AverageStrategy implements Strategy {

  private List<Integer> userFingerHistory;

  public AverageStrategy(List<Integer> userFingerHistory) {
    this.userFingerHistory = userFingerHistory;
  }

  // Choose random value for AI fingers:
  @Override
  public int chooseFingers() {
    return Utils.getRandomNumber(1, 5);
  }

  // Choose random value for AI sum:
  @Override
  public int chooseSum(int fingers) {
    int sum = 0;

    // Find the average of the fingers played by the human and round UP.
    for (int value : userFingerHistory) {
      sum += value;
    }

    double average = (double) sum / userFingerHistory.size();

    return (int) Math.round(average) + fingers;
  }
}
