package nd.rw.game_of_life;

import nd.rw.game_of_life.BoardCell.State;

import java.util.List;

import static nd.rw.game_of_life.BoardCell.State.*;

public class CellRule {

  private final List<BoardCell> cellNeighbours;

  public CellRule(List<BoardCell> cellNeighbours) {
    this.cellNeighbours = cellNeighbours;
  }

  public State calculateNextState() {
    long aliveNeighbours = cellNeighbours.stream().filter(cell -> cell.getState() == ALIVE).count();
    return aliveNeighbours == 2 || aliveNeighbours == 3 ? ALIVE : DEAD;
  }
}
