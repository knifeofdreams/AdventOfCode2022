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

  @Nested
  class FirstScoreCalculation {
    @Test
    public void calculateScore() {
      var shapes = List.of(
          List.of("A", "Y"),
          List.of("B", "X"),
          List.of("C", "Z"));
      var rockPaperScissors = new RockPaperScissors();
      assertEquals(15, rockPaperScissors.totalScore(shapes));
    }

    @Test
    public void calculateScoreForMyInput() {
      var shapes = readInput();
      var rockPaperScissors = new RockPaperScissors();
      assertEquals(13675, rockPaperScissors.totalScore(shapes));
    }
  }

  @Nested
  class SecondScoreCalculation {
    @Test
    public void calculateScore() {
      var shapes = List.of(
          List.of("A", "Y"),
          List.of("B", "X"),
          List.of("C", "Z"));
      var rockPaperScissors = new RockPaperScissors();
      assertEquals(12, rockPaperScissors.totalCorrectScore(shapes));
    }

    @Test
    public void calculateScoreForMyInput() {
      var shapes = readInput();
      var rockPaperScissors = new RockPaperScissors();
      assertEquals(14184, rockPaperScissors.totalCorrectScore(shapes));
    }
  }

  private List<List<String>> readInput() {
    try (Stream<String> input = Files.lines(Path.of(ClassLoader.getSystemResource("day2/day2-input.txt").toURI()))) {
      return input.map(line -> List.of(line.substring(0, 1), line.substring(2))).collect(Collectors.toList());
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new IllegalStateException("Failed to read file");
    }
  }
}
