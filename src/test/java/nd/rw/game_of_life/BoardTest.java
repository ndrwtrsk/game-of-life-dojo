package nd.rw.game_of_life;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class BoardTest {

  @Test
  public void testAccessingCellNeighboursFor3x3BoardForMiddleCell() {
    //  given
    Board board = new Board(3, 3);
    BoardCell middleCell = new BoardCell(1, 1);
    //  when
    List<BoardCell> neighbours = board.collectNeighbours(middleCell);
    //  then
    assertThat(neighbours).hasSize(8);
  }

  @Test
  @Parameters({
      "4,0,0,3",
      "4,1,1,8",
      "4,3,3,3",
      "4,3,0,3",
      "4,0,3,3",
      "5,0,0,3",
      "5,2,2,8",
      "5,4,4,3"})
  public void testParams(int boardDimension, int x, int y, int numberOfNeighbours) {
    Board board = new Board(boardDimension, boardDimension);
    BoardCell selectedCell = new BoardCell(x, y);
    List<BoardCell> neighbours = board.collectNeighbours(selectedCell);
    assertThat(neighbours).hasSize(numberOfNeighbours);
  }

}