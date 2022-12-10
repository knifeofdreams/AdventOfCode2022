package io.github.knifeofdreams.adventofcode.day9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.knifeofdreams.adventofcode.day9.Rope.Move;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class RopeTest {

  @Test
  public void returnsCountOfVisitedFields() {
    var headMoves = readInput("day9/day9-testinput.txt");
    var rope = new Rope();
    assertEquals(13, rope.visitedFieldCount(headMoves));
  }

  private List<Move> readInput(String file) {
    try (Stream<String> input =
        Files.lines(Path.of(ClassLoader.getSystemResource(file).toURI()))) {
      var pattern = Pattern.compile("(\\w) (\\d+)");
      return input
          .map(
              line -> {
                var matcher = pattern.matcher(line);
                if (!matcher.matches()) {
                  throw new IllegalArgumentException("Line does not match the pattern: " + line);
                }
                var direction = matcher.group(1);
                var steps = Integer.parseInt(matcher.group(2));
                return new Move(direction, steps);
              })
          .collect(Collectors.toList());
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new IllegalStateException("Failed to read file");
    }
  }
}