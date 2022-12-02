package io.github.knifeofdreams.gameoflife;

import static java.lang.Math.abs;

import java.util.ArrayList;
import java.util.List;

public class Game {

  private final List<Cell> cells;

  public Game(List cells) {
    this.cells = cells;
  }

  public List tick() {
    List result = new ArrayList();
    for (int i = 0; i < cells.size(); i++) {
      Cell cell = cells.get(i);
      int neighbours = 0;
      int cellX = cell.getX();
      int cellY = cell.getY();

      for (int j = 0; j < cells.size(); j++) {
        Cell neighbour = cells.get(j);
        int neighbourX = neighbour.getX();
        int neighbourY = neighbour.getY();

        if ((i != j) && (abs(cellX - neighbourX) <= 1) && (abs(cellY - neighbourY) <= 1)) {
          neighbours += 1;
        }
      }

      if (neighbours == 2 || neighbours == 3) {
        result.add(cell);
      }
    }
    return result;
  }
}
