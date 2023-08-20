package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {

  // Choose random value for AI fingers:
  @Override
  public int chooseFingers() {
    return Utils.getRandomNumber(1, 5);
  }

  // Choose random value for AI sum:
  @Override
  public int chooseSum(int fingers) {

    return Utils.getRandomNumber(fingers + 1, fingers + 5);
  }
}
