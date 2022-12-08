package io.github.knifeofdreams.adventofcode.day8;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class TreeHouseTest {

  @Test
  public void returnsNoOfVisibleTeas() {
    var grid = List.of();
    var treeHouse = new TreeHouse();
    assertEquals(21, treeHouse.visibleTrees(grid));
  }

}