package io.github.knifeofdreams.adventofcode.day2;

import java.util.List;

public class RockPaperScissors {

  public int totalScore(List<List<String>> shapes) {
    return shapes
        .stream()
        .map(hands -> new Hands(Hand.of(hands.get(0)), Hand.of(hands.get(1))))
        .mapToInt(hands -> hands.self().value() + hands.self().against(hands.elf()))
        .sum();
  }

  public int totalCorrectScore(List<List<String>> shapes) {
    return shapes
        .stream()
        .map(hands -> new HandAndResult(Hand.of(hands.get(0)), Result.of(hands.get(1))))
        .mapToInt(hands -> {
          Hand reverseEngineeredHand = hands.result().against(hands.hand());
          return reverseEngineeredHand.value() + hands.result().value();
        })
        .sum();
  }

  record Hands(Hand elf, Hand self) {}
  record HandAndResult(Hand hand, Result result) {}

  enum Hand {
    ROCK, PAPER, SCISSORS;

    public static Hand of(String hand) {
      return switch (hand) {
        case "A", "X" -> ROCK;
        case "B", "Y" -> PAPER;
        case "C", "Z" -> SCISSORS;
        default -> throw new IllegalArgumentException("Invalid hand " + hand);
      };
    }

    public int value() {
      return switch (this) {
        case ROCK -> 1;
        case PAPER -> 2;
        case SCISSORS -> 3;
      };
    }

    public int against(Hand other) {
      return switch (this) {
        case ROCK ->
           switch (other) {
            case ROCK ->  3;
            case PAPER ->  0;
            case SCISSORS ->  6;
          };

        case PAPER ->
           switch (other) {
            case ROCK -> 6;
            case PAPER -> 3;
            case SCISSORS -> 0;
          };

        case SCISSORS ->
           switch (other) {
          case ROCK ->  0;
          case PAPER ->  6;
          case SCISSORS ->  3;
          };
      };
    }
  }

  enum Result {
    WIN(6), DRAW(3), LOSE(0);

    private int resultValue;

    Result(int resultValue) {
      this.resultValue = resultValue;
    }

    public int value() {
      return resultValue;
    }

    public static Result of(String result) {
      return switch(result) {
          case "X" -> LOSE;
          case "Y" -> DRAW;
          case "Z" -> WIN;
        default -> throw new IllegalArgumentException("Invalid result " + result);
      };
    }

    public Hand against(Hand other) {
      return switch(this) {
        case WIN -> switch (other) {
          case ROCK -> Hand.PAPER;
          case PAPER -> Hand.SCISSORS;
          case SCISSORS -> Hand.ROCK;
        };
        case DRAW -> other;
        case LOSE -> switch (other) {
          case ROCK -> Hand.SCISSORS;
          case PAPER -> Hand.ROCK;
          case SCISSORS -> Hand.PAPER;
        };
      };
    }
  }
}
