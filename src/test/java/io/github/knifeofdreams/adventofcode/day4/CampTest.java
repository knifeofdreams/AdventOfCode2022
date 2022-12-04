package io.github.knifeofdreams.adventofcode.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.knifeofdreams.adventofcode.day4.Camp.Section;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CampTest {
  private static final List<List<Section>> EXAMPLE_PAIRS =
      List.of(
          List.of(new Section(2, 4), new Section(6, 8)),
          List.of(new Section(2, 3), new Section(4, 5)),
          List.of(new Section(5, 7), new Section(7, 9)),
          List.of(new Section(2, 8), new Section(3, 7)),
          List.of(new Section(6, 6), new Section(4, 6)),
          List.of(new Section(2, 6), new Section(4, 8)));
  public static final List<List<Section>> PAIRS = readInput();
  private Camp camp = new Camp();

  @Nested
  class FullOverLap {

    @Test
    public void findFullyContainedPairs() {
      assertEquals(2, camp.numberOfFullOverlaps(EXAMPLE_PAIRS));
    }

    @Test
    public void findFullyContainedPairsForMyInput() {
      assertEquals(450, camp.numberOfFullOverlaps(PAIRS));
    }
  }

  @Nested
  class PartialOverlap {
    @Test
    public void findPartiallyContainedPairs() {
      assertEquals(4, camp.numberOfPartialOverlaps(EXAMPLE_PAIRS));
    }

    @Test
    public void findPartiallyContainedPairsForMyInput() {
      assertEquals(0, camp.numberOfPartialOverlaps(PAIRS));
    }
  }

  private static List<List<Section>> readInput() {
    try (Stream<String> input =
        Files.lines(Path.of(ClassLoader.getSystemResource("day4/day4-input.txt").toURI()))) {
      var pattern = Pattern.compile("(\\d+)-(\\d+),(\\d+)-(\\d+)");
      return input
          .map(
              line -> {
                var matcher = pattern.matcher(line);
                if (!matcher.matches()) {
                  throw new IllegalArgumentException("Line does not match the pattern: " + line);
                }
                var firstSectionBeginning = Integer.parseInt(matcher.group(1));
                var firstSectionEnd = Integer.parseInt(matcher.group(2));
                var secondSectionBeginning = Integer.parseInt(matcher.group(3));
                var secondSectionEnd = Integer.parseInt(matcher.group(4));
                return List.of(
                    new Section(firstSectionBeginning, firstSectionEnd),
                    new Section(secondSectionBeginning, secondSectionEnd));
              })
          .collect(Collectors.toList());
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new IllegalStateException("Failed to read file");
    }
  }
}
