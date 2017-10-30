package nd.rw.game_of_life;

import java.util.List;

public class CellRule {

  private final List<BoardCell> cellNeighbours;

  public CellRule(List<BoardCell> cellNeighbours) {
    this.cellNeighbours = cellNeighbours;
  }

  public BoardCell.State calculateNextState() {

  }
}
