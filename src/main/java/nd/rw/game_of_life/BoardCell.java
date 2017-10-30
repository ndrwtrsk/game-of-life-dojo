package nd.rw.game_of_life;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class BoardCell {

  @Getter
  private final int row;

  @Getter
  private final int column;

  @Getter
  @Setter
  private State state = State.DEAD;

  @Getter
  @Setter
  private State nextState = State.DEAD;

  public BoardCell(int row, int column) {
    this.row = row;
    this.column = column;
  }

  public BoardCell(int row, int column, State state) {
    this.row = row;
    this.column = column;
    this.state = state;
  }

  public enum State {
    ALIVE, DEAD
  }
}
