package io.github.knifeofdreams.adventofcode.day8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class TreeHouseTest {

  @Test
  public void returnsNoOfVisibleTeas() {
    var grid = List.of(
        List.of(3,0,3,7,3),
        List.of(2,5,5,1,2),
        List.of(6,5,3,3,2),
        List.of(3,3,5,4,9),
        List.of(3,5,3,9,0)
    );
    var treeHouse = new TreeHouse();
    assertEquals(21, treeHouse.visibleTrees(grid));
  }

  @Test
  public void returnsNoOfVisibleTeasForMyInput() {
    var grid = readInput();
    var treeHouse = new TreeHouse();
    assertEquals(0, treeHouse.visibleTrees(grid));
  }

  private List<List<Integer>> readInput() {
    try (Stream<String> input =
        Files.lines(Path.of(ClassLoader.getSystemResource("day8/day8-input.txt").toURI()))) {
      return input
          .map(line ->
            Stream.of(line.split(""))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList())
          )
          .collect(Collectors.toList());
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new IllegalStateException("Failed to read file");
    }
  }
}