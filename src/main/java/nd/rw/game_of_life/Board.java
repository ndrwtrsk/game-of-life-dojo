package nd.rw.game_of_life;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
public class Board implements CellNeighbourAccessor {

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
    int cellColumn = cell.getColumn(),
        cellRow = cell.getRow();
    return board.cellSet()
        .stream()
        .filter(tableCell -> !Objects.equals(tableCell.getValue(), cell))
        .filter(tableCell -> {
          int x = Math.abs(cellColumn - tableCell.getColumnKey());
          int y = Math.abs(cellRow - tableCell.getRowKey());
          return calculateVector(x, y) == 1;
        })
        .map(Table.Cell::getValue)
        .collect(Collectors.toList());
  }

  private int calculateVector(int x, int y){
    x = x == 0 ? 1 : x;
    y = y == 0 ? 1 : y;
    return x * y;
  }
}
