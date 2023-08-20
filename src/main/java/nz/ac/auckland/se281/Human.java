package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

public class Human {

  public List<Integer> play() {

    int humanFingers = 0;
    int humanSum = 0;

    // Continue prompting the user for correct input values:
    do {
      MessageCli.ASK_INPUT.printMessage();

      String input = Utils.scanner.nextLine();
      String[] inputs = input.split(" ");

      if (inputs.length != 2) {
        MessageCli.INVALID_INPUT.printMessage();
        continue;
      }

      boolean booleanFingers = Utils.isInteger(inputs[0]);
      boolean booleanSum = Utils.isInteger(inputs[1]);

      if (!booleanFingers || !booleanSum) {
        MessageCli.INVALID_INPUT.printMessage();
        continue;
      }

      humanFingers = Integer.parseInt(inputs[0]);
      humanSum = Integer.parseInt(inputs[1]);

      if (humanFingers < 1 || humanFingers > 5 || humanSum < 1 || humanSum > 10) {
        MessageCli.INVALID_INPUT.printMessage();
        continue;
      }

    } while (humanFingers < 1 || humanFingers > 5 || humanSum < 1 || humanSum > 10);

    // make new list to store the human finger and sum and return:
    List<Integer> human = new ArrayList<>();
    human.add(humanFingers);
    human.add(humanSum);

    return human;
  }
}
