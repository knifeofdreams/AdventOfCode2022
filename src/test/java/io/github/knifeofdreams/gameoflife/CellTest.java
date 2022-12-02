package io.github.knifeofdreams.gameoflife;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CellTest {

  @Test
  public void xReturnsXCoordinate() {
    var cell = new Cell(0,1);

    assertEquals(0, cell.getX());
  }

  @Test
  public void yReturnsYCoordinate() {
    var cell = new Cell(0,1);

    assertEquals(1, cell.getY());
  }

  @Test
  public void equalsReturnsFalseForDifferentCoordinates() {
    var cell1 = new Cell(0, 0);
    var cell2 = new Cell(1,1);

    assertFalse(cell1.equals(cell2));
  }

  @Test
  public void equalsReturnsTrueForSameCell() {
    var cell = new Cell(0, 0);

    assertTrue(cell.equals(cell));
  }

  @Test
  public void equalsReturnsTrueForSameCoordinates() {
    var cell1 = new Cell(0, 0);
    var cell2 = new Cell(0, 0);

    assertTrue(cell1.equals(cell2));
  }
}