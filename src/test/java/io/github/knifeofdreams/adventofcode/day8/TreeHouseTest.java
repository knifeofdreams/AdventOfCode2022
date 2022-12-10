package io.github.knifeofdreams.adventofcode.day8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class TreeHouseTest {

  @Test
  public void returnsNoOfVisibleTreas() {
    var grid = readInput("day8/day8-testinput.txt");
    var treeHouse = new TreeHouse();
    assertEquals(21, treeHouse.visibleTrees(grid));
  }

  @Test
  public void returnsNoOfVisibleTreasForMyInput() {
    var grid = readInput("day8/day8-input.txt");
    var treeHouse = new TreeHouse();
    assertEquals(1827, treeHouse.visibleTrees(grid));
  }

  @Test
  public void returnsScenicScore() {
    var grid = readInput("day8/day8-testinput.txt");
    var treeHouse = new TreeHouse();
    assertEquals(8, treeHouse.scenicScore(grid));
  }

  @Test
  public void returnsScenicScoreForMyInput() {
    var grid = readInput("day8/day8-input.txt");
    var treeHouse = new TreeHouse();
    assertEquals(0, treeHouse.scenicScore(grid));
  }

  private List<List<Tree>> readInput(String filename) {
    List<List<Tree>> rows = new ArrayList<>();
    try (BufferedReader in =
        Files.newBufferedReader(Path.of(ClassLoader.getSystemResource(filename).toURI()))) {

      String line;
      while ((line = in.readLine()) != null) {
        List<Tree> columns = new ArrayList<>();
        for (int i = 0; i < line.length(); i++) {
          int height = Character.digit(line.charAt(i), 10);
          columns.add(new Tree(height, rows.size(), i, false));
        }
        rows.add(columns);
      }

    } catch (Exception ex) {
      ex.printStackTrace();
      throw new IllegalStateException("Failed to read file");
    }

    return rows;
  }
}