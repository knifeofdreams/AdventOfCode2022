package io.github.knifeofdreams.adventofcode.day9;

import java.util.HashSet;
import java.util.List;

public class Rope {

  public int visitedFieldCount(List<String> moves) {
    var head = new Position(0, 0);
    var tail = new Position(0, 0);
    var tailPositions = new HashSet<Position>();
    tailPositions.add(tail);

    for (String move: moves) {
      if (move.equals("U")) {
        head.y += 1;
      }
      else if (move.equals("D")) {
        head.y -= 1;
      }
      else if (move.equals("L")) {
        head.x -= 1;
      }
      else if (move.equals("R")) {
        head.x += 1;
      }
      else {
        throw new IllegalStateException("Unknown move: " + move);
      }

      if (!tail.withinDistanceOfOne(head)) {
        if (tail.x - head.x == 2 && tail.y.equals(head.y)) {
          tail.x -= 1;
        }
        else if (tail.x - head.x == -2 && tail.y.equals(head.y)) {
          tail.x += 1;
        }
        else if (tail.x.equals(head.x) && tail.y - head.y == 2) {
          tail.y -= 1;
        }
        else if (tail.x.equals(head.x) && tail.y - head.y == -2) {
          tail.y += 1;
        }
        else if ((tail.x - head.x == -1 && tail.y - head.y == -2)
          || (tail.x - head.x == -2 && tail.y - head.y == -1)) {
          // TODO looks good
          tail.x += 1;
          tail.y += 1;
        }
        else if ((tail.x - head.x == -2 && tail.y - head.y == 1)
            || (tail.x - head.x == -1 && tail.y - head.y == 2)) {
          tail.x += 1;
          tail.y -= 1;
        }
        else if ((tail.x - head.x == 1 && tail.y - head.y ==2)
            || (tail.x - head.x == 2 && tail.y - head.y == 1)) {
          // TODO looks good
          tail.x -= 1;
          tail.y -= 1;
        }
        else if ((tail.x - head.x == 2 && tail.y - head.y == -1)
            || (tail.x - head.x == 1 && tail.y - head.y == -2)) {
          // TODO looks good
          tail.x -= 1;
          tail.y += 1;
        }
        else {
          throw new IllegalStateException("Illegal state, tail: " + tail + ", head: " + head);
        }

          tailPositions.add(tail);
      }
    }

    return tailPositions.size();
  }
}
