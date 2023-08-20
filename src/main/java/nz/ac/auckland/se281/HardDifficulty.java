package nz.ac.auckland.se281;

import java.util.List;

// Factory
public class HardDifficulty implements Jarvis {

  private Strategy strategy = new RandomStrategy();

  private List<Integer> userFingerHistory;

  public HardDifficulty(List<Integer> userFingerHistory) {
    this.userFingerHistory = userFingerHistory;
  }

  // returns AI fingers:
  @Override
  public int getFingers() {
    return strategy.chooseFingers();
  }

  // returns AI sum:
  @Override
  public int getSum(int aiFingers) {
    // At round 4 and onwards, switch to top strategy:
    if ((userFingerHistory.size() + 1) > 3) {
      setStrategy(new TopStrategy(userFingerHistory));
      return strategy.chooseSum(aiFingers);
    }

    // For rounds 1 - 3, use random strategy:
    return strategy.chooseSum(aiFingers);
  }

  // Change strategy at run time:
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }
}
