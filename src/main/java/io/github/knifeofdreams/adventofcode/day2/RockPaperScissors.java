package io.github.knifeofdreams.adventofcode.day2;

import java.util.List;

public class RockPaperScissors {

  public int totalScore(List<List<String>> shapes) {
    return shapes
        .stream()
        .mapToInt(hand -> calculateShapeValue(hand.get(1)) + calculateGameScore(hand))
        .sum();
  }

  public int totalCorrectScore(List<List<String>> shapes) {
    return shapes
        .stream()
        .mapToInt(hand -> calculateShapeValue(calculateCorrectShape(hand)) + calculateCorrectGameScore(hand.get(1)))
        .sum();
  }

  private String calculateCorrectShape(List<String> hands) {
    if (hands.get(0).equals("A") && hands.get(1).equals("X")) {
      return "Z";
    }
    else if (hands.get(0).equals("A") && hands.get(1).equals("Y")) {
      return "X";
    }
    else if (hands.get(0).equals("A") && hands.get(1).equals("Z")) {
      return "Y";
    }
    else if (hands.get(0).equals("B") && hands.get(1).equals("X")) {
      return "X";
    }
    else if (hands.get(0).equals("B") && hands.get(1).equals("Y")) {
      return "Y";
    }
    else if (hands.get(0).equals("B") && hands.get(1).equals("Z")) {
      return "Z";
    }
    else if (hands.get(0).equals("C") && hands.get(1).equals("X")) {
      return "Y";
    }
    else if (hands.get(0).equals("C") && hands.get(1).equals("Y")) {
      return "Z";
    }
    else if (hands.get(0).equals("C") && hands.get(1).equals("Z")) {
      return "X";
    }
    else {
      throw new IllegalArgumentException("Non-existing hand");
    }
  }

  private int calculateShapeValue(String shape) {
    return switch (shape) {
      case "X" -> 1;
      case "Y" -> 2;
      case "Z" -> 3;
      default -> throw new IllegalArgumentException("Wrong shape");
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

  private int calculateCorrectGameScore(String result) {
    return switch (result) {
      case "X" -> 0;
      case "Y" -> 3;
      case "Z" -> 6;
      default -> throw new IllegalArgumentException("Non-existing result");
    };
  }
}
