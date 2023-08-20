package nz.ac.auckland.se281;

import java.util.List;

// Factory
public class MasterDifficulty implements Jarvis {

  private Strategy strategy = new RandomStrategy();

  private List<Integer> userFingerHistory;

  public MasterDifficulty(List<Integer> userFingerHistory) {
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
    // At round 4 and onwards, alternate between average and top:
    if ((userFingerHistory.size() + 1) > 3) {

      // if the round is even, switch to average strategy:
      if ((userFingerHistory.size() + 1) % 2 == 0) {
        setStrategy(new AverageStrategy(userFingerHistory));
        return strategy.chooseSum(aiFingers);
      }

      // if the round is odd, switch to top strategy:
      if ((userFingerHistory.size() + 1) % 2 == 1) {
        setStrategy(new TopStrategy(userFingerHistory));
        return strategy.chooseSum(aiFingers);
      }
    }

    // For rounds 1 - 3, use random strategy:
    return strategy.chooseSum(aiFingers);
  }

  // Change strategy at run time:
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }
}
