package nz.ac.auckland.se281;

// easy difficulty:
public class EasyDifficulty implements Jarvis {

  private Strategy strategy = new RandomStrategy();

  // returns AI fingers:
  @Override
  public int getFingers() {
    return strategy.chooseFingers();
  }

  // returns AI sum:
  @Override
  public int getSum(int aiFingers) {
    return strategy.chooseSum(aiFingers);
  }
}
