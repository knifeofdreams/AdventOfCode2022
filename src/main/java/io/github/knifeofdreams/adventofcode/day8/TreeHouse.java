package io.github.knifeofdreams.adventofcode.day8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TreeHouse {

  public int scenicScore(List<List<Tree>> grid) {
    int maxScenicScore = 0;
    for (int row = 0; row < grid.size(); row++) {
      for (int column = 0; column < grid.get(0).size(); column++) {
        var height = grid.get(row).get(column).height;
        var upScenicScore = 0;
        var downScenicScore = 0;
        var leftScenicScore = 0;
        var rightScenicScore = 0;

        // look up
        var r = row - 1;
        while (r >= 0) {
          int h = grid.get(r).get(column).height;
          if (h >= height) {
            upScenicScore += 1;
            break;
          } else {
            upScenicScore += 1;
            r -= 1;
          }
        }

        // look down
        r = row + 1;
        while (r <= grid.size() - 1) {
          int h = grid.get(r).get(column).height;
          if (h >= height) {
            downScenicScore += 1;
            break;
          } else {
            downScenicScore += 1;
            r += 1;
          }
        }

        // look left
        var c = column - 1;
        while (c >= 0) {
          int h = grid.get(row).get(c).height;
          if (h >= height) {
            leftScenicScore += 1;
            break;
          } else {
            leftScenicScore += 1;
            c -= 1;
          }
        }

        // look right
        c = column + 1;
        while (c <= grid.get(0).size() - 1) {
          int h = grid.get(row).get(c).height;
          if (h >= height) {
            rightScenicScore += 1;
            break;
          } else {
            rightScenicScore += 1;
            c += 1;
          }
        }

        if ((leftScenicScore * rightScenicScore * upScenicScore * downScenicScore) > maxScenicScore) {
          maxScenicScore = leftScenicScore * rightScenicScore * upScenicScore * downScenicScore;
        }
      }
    }
    return maxScenicScore;
  }

  public int visibleTrees(List<List<Tree>> grid) {
    var visible = 0;
    var visibleTrees = new ArrayList<>();

    for (List<Tree> row : grid) {
      var minHeight = -1;
      for (Tree tree : row) {
        if (tree.height > minHeight && !tree.seen) {
          visible += 1;
          minHeight = tree.height;
          visibleTrees.add(tree);
          tree.seen = true;
        }
      }
    }

    for (List<Tree> row : grid) {
      var minHeight = -1;
      for (int i = row.size() - 1; i > -1; i--) {
        Tree tree = row.get(i);
        if (tree.height > minHeight) {
          minHeight = tree.height;
          if (!tree.seen) {
            visible += 1;
            visibleTrees.add(tree);
            tree.seen = true;
          }
        }
      }
    }

    var transposedGrid = transpose(grid);

    for (List<Tree> row : transposedGrid) {
      var minHeight = -1;
      for (Tree tree : row) {
        if (tree.height > minHeight) {
          minHeight = tree.height;
          if (!tree.seen) {
            visible += 1;
            visibleTrees.add(tree);
            tree.seen = true;
          }
        }
      }
    }

    for (List<Tree> row : transposedGrid) {
      var minHeight = -1;
      for (int i = row.size() - 1; i > -1; i--) {
        Tree tree = row.get(i);
        if (tree.height > minHeight) {
          minHeight = tree.height;
          if (!tree.seen) {
            visible += 1;
            visibleTrees.add(tree);
            tree.seen = true;
          }
        }
      }
    }

    return visible;
  }

  private ArrayList<ArrayList<Tree>> transpose(List<List<Tree>> grid) {
    var transposedGrid = new ArrayList<ArrayList<Tree>>();

    for (int row = 0; row < grid.size(); row++) {
      var transposedRow = new ArrayList<Tree>();
      for (int column = 0; column < grid.get(0).size(); column++) {
        transposedRow.add(
            new Tree(
                grid.get(column).get(row).height, column, row, grid.get(column).get(row).seen));
      }
      transposedGrid.add(transposedRow);
    }

    return transposedGrid;
  }
}
