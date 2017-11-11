package nd.rw.game_of_life;

import com.google.common.collect.Lists;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import nd.rw.game_of_life.BoardCell.State;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static nd.rw.game_of_life.BoardCell.State.ALIVE;
import static nd.rw.game_of_life.BoardCell.State.DEAD;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
 * Any live cell with two or three live neighbours lives on to the next generation.
 * Any live cell with more than three live neighbours dies, as if by overpopulation.
 * Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
 */
@RunWith(JUnitParamsRunner.class)
public class CellRuleTest {

  @Test
  @Parameters({
      "1,7,DEAD",
      "2,6,ALIVE",
      "3,5,ALIVE",
      "4,4,DEAD",
      "5,3,DEAD",
      "6,2,DEAD",
      "7,1,DEAD",
  })
  public void parametrizedTest(int aliveNeighbours, int deadNeighbours, State targetState){
    //  given
    List<BoardCell> neighbours = getListOfNeighbours(aliveNeighbours, deadNeighbours);
    CellRule rule = new CellRule(neighbours);
    //  when
    State state = rule.calculateNextState();
    //  then
    assertThat(state).isEqualTo(targetState);
  }

  private List<BoardCell> getListOfNeighbours(int numberOfAlive, int numberOfDead){
    List<BoardCell> result = Lists.newArrayList();
    for (int i = 0; i < numberOfAlive; i++) {
      result.add(new BoardCell(0,0, ALIVE));
    }
    for (int i = 0; i < numberOfDead; i++) {
      result.add(new BoardCell(0,0, DEAD));
    }
    return result;
  }


}