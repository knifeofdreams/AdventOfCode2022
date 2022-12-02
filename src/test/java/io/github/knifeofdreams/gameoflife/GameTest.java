package io.github.knifeofdreams.gameoflife;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import org.junit.jupiter.api.Test;

public class GameTest {

  @Test
  public void emptyGameResultsInEmptyGame() {
    var game = new Game(List.of());
    assertEquals(game.tick(), List.of());
  }

  @Test
  public void lonelyCellDies() {
    var game = new Game(List.of(new Cell(0, 0)));
    assertEquals(List.of(), game.tick());
  }

  @Test
  public void cellsWithTwoNeighbourLives() {
    List<Cell> cells = List.of(new Cell(0, 0), new Cell(1, 0), new Cell(1, 0));
    var game = new Game(cells);

    assertEquals(List.of(new Cell(0, 0), new Cell(1, 0), new Cell(1, 0)), game.tick());
  }

  @Test
  public void cellsWithLessThanThreeNeighboursDie() {
    var game = new Game(List.of(new Cell(0, 0), new Cell(0, 1), new Cell(0, 2)));

    assertEquals(List.of(new Cell(0, 1)), game.tick());
  }

  @Test
  public void cellWithMoreThanThreeNeighboursDie() {
    var game = new Game(List.of(new Cell(0, 1), new Cell(1, 0), new Cell(1, 1), new Cell(1, 1), new Cell(1, 3), new Cell(2, 0), new Cell(2, 1)));

    assertFalse(game.tick().contains(new Cell(1, 0)));
  }
}
