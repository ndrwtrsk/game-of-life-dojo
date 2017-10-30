package nd.rw.game_of_life;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class Board implements CellNeighbourAccessor {

  @Getter
  private final Integer numberOfRows, numberOfColumns;
  private Table<Integer, Integer, BoardCell> board;

  public Board(Integer numberOfRows, Integer numberOfColumns) {
    this.numberOfRows = numberOfRows;
    this.numberOfColumns = numberOfColumns;
    setUpBoard();
  }

  private void setUpBoard() {
    board = HashBasedTable.create(this.numberOfRows, this.numberOfColumns);
    for (int row = 0; row < this.numberOfRows; row++) {
      for (int column = 0; column < this.numberOfColumns; column++) {
        board.put(row, column, new BoardCell(row, column));
      }
    }
  }

  @Override
  public List<BoardCell> collectNeighbours(BoardCell cell) {
    int x = cell.getRow(), y = cell.getColumn();
    return board.cellSet().stream()
        .filter(tableCell -> tableCell.getValue() != cell)
        .filter(tableCell -> Math.abs(x - tableCell.getRowKey()) >= 1 ||
            Math.abs(y - tableCell.getColumnKey()) >= 1)
        .map(Table.Cell::getValue)
        .collect(Collectors.toList());
  }
}
