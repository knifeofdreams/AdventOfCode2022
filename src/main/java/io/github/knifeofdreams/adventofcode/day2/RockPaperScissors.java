package io.github.knifeofdreams.adventofcode.day2;

import java.util.List;

public class RockPaperScissors {

  public int totalScore(List<List<String>> hands) {
    return hands.stream()
        .mapToInt(hand -> calculateHandValue(hand.get(1)) + calculateGameScore(hand))
        .sum();
  }

  private int calculateHandValue(String hand) {
    return switch (hand) {
      case "X" -> 1;
      case "Y" -> 2;
      case "Z" -> 3;
      default -> throw new IllegalArgumentException("Wrong hand");
    };
  }

  private int calculateGameScore(List<String> hands) {
      if (hands.get(0).equals("A") && hands.get(1).equals("X")) {
        return 3;
      }
      else if (hands.get(0).equals("B") && hands.get(1).equals("Y")) {
        return 3;
      }
      else if (hands.get(0).equals("C") && hands.get(1).equals("Z")) {
        return 3;
      }
      else if (hands.get(0).equals("A") && hands.get(1).equals("Z")) {
        return 0;
      }
      else if (hands.get(0).equals("B") && hands.get(1).equals("X")) {
        return 0;
      }
      else if (hands.get(0).equals("C") && hands.get(1).equals("Y")) {
        return 0;
      }
      else if (hands.get(0).equals("A") && hands.get(1).equals("Y")) {
        return 6;
      }
      else if (hands.get(0).equals("B") && hands.get(1).equals("Z")) {
        return 6;
      }
      else if (hands.get(0).equals("C") && hands.get(1).equals("X")) {
        return 6;
      }
      else {
        throw new IllegalArgumentException("Non-existing hand");
    }
  }
}
