package nz.ac.auckland.se281;

import java.util.List;

public class TopStrategy implements Strategy {

  private List<Integer> userFingerHistory;

  public TopStrategy(List<Integer> userFingerHistory) {
    this.userFingerHistory = userFingerHistory;
  }

  // Choose value for AI finger:
  @Override
  public int chooseFingers() {
    return Utils.getRandomNumber(1, 5);
  }

  // Choose value for AI sum:
  @Override
  public int chooseSum(int fingers) {
    int top = 0;
    int count = 0;

    // algorithm to find the element that occurs the most:
    for (int i = 0; i < userFingerHistory.size(); i++) {
      int tempTop = userFingerHistory.get(i);
      int tempCount = 0;

      for (int j = 0; j < userFingerHistory.size(); j++) {
        if (userFingerHistory.get(j) == tempTop) {
          tempCount++;
        }
      }

      if (tempCount > count) {
        top = tempTop;
        count = tempCount;
      }
    }

    return fingers + top;
  }
}
