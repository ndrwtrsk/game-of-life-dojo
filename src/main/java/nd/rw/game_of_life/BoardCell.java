package nd.rw.game_of_life;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

import static nd.rw.game_of_life.BoardCell.State.*;

@ToString
@EqualsAndHashCode
public class BoardCell {

  @Getter
  private final int row;

  @Getter
  private final int column;

  private State state = DEAD;
  private State nextState = NONE;

  public BoardCell(int row, int column) {
    this.row = row;
    this.column = column;
  }

  public BoardCell(int row, int column, State state) {
    this.row = row;
    this.column = column;
    this.state = state;
  }

  public void computeNextStateWithAccessor(CellNeighbourAccessor accessor){
    List<BoardCell> neighbours = accessor.collectNeighbours(this);
    CellRule rule = new CellRule(neighbours);
    nextState = rule.calculateNextState();
  }

  public void activateNextState(){
    state = nextState;
    nextState = NONE;
  }

  public boolean isAlive(){
    return state == ALIVE;
  }

  public enum State {
    ALIVE, DEAD, NONE
  }
}
