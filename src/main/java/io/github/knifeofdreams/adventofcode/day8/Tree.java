package io.github.knifeofdreams.adventofcode.day8;

import java.util.Objects;

final class Tree {

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
    if (obj == this) {
      return true;
    }
    if (obj == null || obj.getClass() != this.getClass()) {
      return false;
    }
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
