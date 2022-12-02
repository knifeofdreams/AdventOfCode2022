package io.github.knifeofdreams.adventofcode.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RockPaperScissorsTest {

  private static final List<List<String>> HANDS_EXAMPLE = List.of(List.of("A", "Y"), List.of("B", "X"), List.of("C", "Z"));
  private static final List<List<String>> HANDS = readInput();

  private RockPaperScissors rockPaperScissors = new RockPaperScissors();

  @Nested
  class FirstScoreCalculation {
    @Test
    public void calculateScore() {
      assertEquals(15, rockPaperScissors.totalScore(HANDS_EXAMPLE));
    }

    @Test
    public void calculateScoreForMyInput() {
      assertEquals(13675, rockPaperScissors.totalScore(HANDS));
    }
  }

  @Nested
  class SecondScoreCalculation {
    @Test
    public void calculateScore() {
      assertEquals(12, rockPaperScissors.totalCorrectScore(HANDS_EXAMPLE));
    }

    @Test
    public void calculateScoreForMyInput() {
      assertEquals(14184, rockPaperScissors.totalCorrectScore(HANDS));
    }
  }

  private static List<List<String>> readInput() {
    try (Stream<String> input =
        Files.lines(Path.of(ClassLoader.getSystemResource("day2/day2-input.txt").toURI()))) {
      return input
          .map(line -> List.of(line.substring(0, 1), line.substring(2)))
          .collect(Collectors.toList());
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new IllegalStateException("Failed to read file");
    }
  }
}
