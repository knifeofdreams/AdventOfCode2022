package io.github.knifeofdreams.adventofcode.day8;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TreeHouse {

  static final class Tree {

    public final int height;
    public final int row;
    public final int column;
    public boolean seen;

    Tree(int height, int row, int column, boolean seen) {
      this.height = height;
      this.row = row;
      this.column = column;
      this.seen = seen;
    }

    public int height() {
      return height;
    }

    public int row() {
      return row;
    }

    public int column() {
      return column;
    }

    public boolean seen() {
      return seen;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) return true;
      if (obj == null || obj.getClass() != this.getClass()) return false;
      var that = (Tree) obj;
      return this.height == that.height
          && this.row == that.row
          && this.column == that.column
          && this.seen == that.seen;
    }

    @Override
    public int hashCode() {
      return Objects.hash(height, row, column, seen);
    }

    @Override
    public String toString() {
      return "Tree[" + "height=" + height + ", " + "row=" + row + ", " + "column=" + column + ", "
          + "seen=" + seen + ']';
    }
  }

  public int visibleTrees(List<List<Tree>> grid) {
    var visible = 0;
    var visibleTrees = new ArrayList<>();

    //      var left = 0;
    //      var right = row.size() - 1;
    //      var leftMax = -1;
    //      var rightMax = -1;
    //
    //      // TODO condition is not when the pointers meet but when the max heights become the same
    //      while (left <= right) {
    //        if (row.get(left).height > leftMax) {
    //          leftMax = row.get(left).height;
    //          if (!row.get(left).seen) {
    //            visible += 1;
    //            visibleTrees.add(row.get(left));
    //          }
    //        }
    //        if (row.get(right).height > rightMax) {
    //          rightMax = row.get(right).height;
    //          if (!row.get(right).seen) {
    //            visible += 1;
    //            visibleTrees.add(row.get(right));
    //          }
    //        }
    //        left += 1;
    //        right -= 1;
    //      }
    //    }
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
    //    for (ArrayList<Tree> row : transposedGrid) {
    //      var left = 0;
    //      var right = row.size() - 1;
    //      var leftMax = -1;
    //      var rightMax = -1;
    //
    //      while (left <= right) {
    //        if (row.get(left).height > leftMax) {
    //          leftMax = row.get(left).height;
    //          if (!row.get(left).seen) {
    //            visible += 1;
    //            visibleTrees.add(row.get(left));
    //          }
    //        }
    //        if (row.get(right).height > rightMax) {
    //          rightMax = row.get(right).height;
    //          if (!row.get(right).seen) {
    //            visible += 1;
    //            visibleTrees.add(row.get(right));
    //          }
    //        }
    //        left += 1;
    //        right -= 1;
    //      }
    //    }

    return visible;
  }

  private ArrayList<ArrayList<Tree>> transpose(List<List<Tree>> grid) {
    var transposedGrid = new ArrayList<ArrayList<Tree>>();

    for (int row = 0; row < grid.size(); row++) {
      var transposedRow = new ArrayList<Tree>();
      for (int column = 0; column < grid.get(0).size(); column++) {
        //        transposedRow.add(grid.get(column).get(row));
        transposedRow.add(
            new Tree(
                grid.get(column).get(row).height, column, row, grid.get(column).get(row).seen));
      }
      transposedGrid.add(transposedRow);
    }

    return transposedGrid;
  }
}
