package io.github.knifeofdreams.adventofcode.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class RockPaperScissorsTest {

  @Test
  public void calculateScore() {
    var hands = List.of(
        List.of("A", "Y"),
        List.of("B", "X"),
        List.of("C", "Z"));
    var rockPaperScissors = new RockPaperScissors();
    assertEquals(15, rockPaperScissors.totalScore(hands));
  }

  @Test
  public void calculateScoreForMyInput() {
    var hands = readInput();
    var rockPaperScissors = new RockPaperScissors();
    assertEquals(13675, rockPaperScissors.totalScore(hands));
  }


  List<List<String>> readInput() {
    try (Stream<String> input = Files.lines(Path.of(ClassLoader.getSystemResource("day2/day2-input.txt").toURI()))) {
      return input.map(line -> List.of(line.substring(0, 1), line.substring(2))).collect(Collectors.toList());
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new IllegalStateException("Failed to read file");
    }
  }

  @Test
  public void test() {
    var x = readInput();
    assertEquals(2500, x.size());
  }
}
