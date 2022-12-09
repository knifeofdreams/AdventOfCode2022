package io.github.knifeofdreams.adventofcode.day8;

import java.util.ArrayList;
import java.util.List;

public class TreeHouse {

  public int visibleTrees(List<List<Integer>> grid) {
    var visible = 0;
    var visibleTrees = new ArrayList<>();

    for (List<Integer> row : grid) {
      var minHeight = -1;
      for (Integer tree: row) {
        if (tree > minHeight) {
          visible += 1;
          visibleTrees.add(tree);
          minHeight = tree;
        }
      }
    }

    for (List<Integer> row : grid) {
      var minHeight = -1;
      for (int i = row.size() - 1; i > -1; i--) {
        if (row.get(i) > minHeight) {
          visible += 1;
          visibleTrees.add(row.get(i));
          minHeight = row.get(i);
        }
      }
    }

    var transposedGrid = transpose(grid);

    for (List<Integer> row : transposedGrid) {
      var minHeight = -1;
      for (Integer tree: row) {
        if (tree > minHeight) {
          visible += 1;
          visibleTrees.add(tree);
          minHeight = tree;
        }
      }
    }

    for (List<Integer> row : transposedGrid) {
      var minHeight = -1;
      for (int i = row.size() - 1; i > -1; i--) {
        if (row.get(i) > minHeight) {
          visible += 1;
          visibleTrees.add(row.get(i));
          minHeight = row.get(i);
        }
      }
    }

    return visible;
  }

  private ArrayList<ArrayList<Integer>> transpose(List<List<Integer>> grid) {
    var transposedGrid = new ArrayList<ArrayList<Integer>>();

    for (int row = 0; row < grid.size(); row++) {
      var transposedRow = new ArrayList<Integer>();
      for (int column = 0; column < grid.get(0).size(); column++) {
        transposedRow.add(grid.get(column).get(row));
      }
      transposedGrid.add(transposedRow);
    }

    return transposedGrid;
  }

}
