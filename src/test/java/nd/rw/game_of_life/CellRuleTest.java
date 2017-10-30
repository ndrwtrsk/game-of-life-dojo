package nd.rw.game_of_life;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
 * Any live cell with two or three live neighbours lives on to the next generation.
 * Any live cell with more than three live neighbours dies, as if by overpopulation.
 * Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
 */
@RunWith(MockitoJUnitRunner.class)
public class CellRuleTest {

  @Test
  public void testUnderPopulation_ShouldBeDead_FewerThan2AliveNeighbours() {
    //  given
    List<BoardCell> neighbours = Lists.newArrayList();
    CellRule rule = new CellRule(neighbours);
    //  when
    BoardCell.State state = rule.calculateNextState();
    //  then
    assertThat(state).isEqualTo(BoardCell.State.DEAD);
  }

}