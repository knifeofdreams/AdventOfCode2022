package io.github.knifeofdreams.adventofcode.day9;

import static java.lang.Math.abs;

import java.util.Objects;

public class Position {

  public Integer x;
  public Integer y;

  Position(Integer x, Integer y) {
    this.x = x;
    this.y = y;
  }

  public Integer x() {
    return x;
  }

  public Integer y() {
    return y;
  }

  public boolean withinDistanceOfOne(Position other) {
    return (abs(x - other.x) <= 1) && (abs(y - other.y) <= 1);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null || obj.getClass() != this.getClass()) return false;
    var that = (io.github.knifeofdreams.adventofcode.day9.Position) obj;
    return Objects.equals(this.x, that.x) && Objects.equals(this.y, that.y);
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  @Override
  public String toString() {
    return "Position[" + "x=" + x + ", " + "y=" + y + ']';
  }
}
