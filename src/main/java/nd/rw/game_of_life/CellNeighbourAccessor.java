package nd.rw.game_of_life;

import java.util.List;

public interface CellNeighbourAccessor {

  List<BoardCell> collectNeighbours(BoardCell cell);

}
