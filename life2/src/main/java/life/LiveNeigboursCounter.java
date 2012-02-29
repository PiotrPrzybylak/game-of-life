package life;

public class LiveNeigboursCounter {

	static int countLiveNeigbours(ColumnNumber x, RowNumber y, Cell[][] board) {
		int liveNeighbours = 0;
		for (NeighbourgPosition neighbourgPosition : NeighbourgPosition.values()) {
			int neighbourX = x.getValue() + neighbourgPosition.getX();
			int neighbourY = y.getValue() + neighbourgPosition.getY();
			liveNeighbours = increamentCounterIfNeighbourIsAlive(board, liveNeighbours, neighbourX, neighbourY);
		}
		return liveNeighbours;
	}

	private static int increamentCounterIfNeighbourIsAlive(Cell[][] board, int liveNeighbours, int neighbourX,
			int neighbourY) {
		boolean outOfBoardBound = isOutOfBoardBound(board, neighbourX, neighbourY);
		if (outOfBoardBound) {
			return liveNeighbours;
		}

		if (board[neighbourY][neighbourX].value() == '*') {
			liveNeighbours++;
		}
		return liveNeighbours;
	}

	public static boolean isOutOfBoardBound(Cell[][] board, int neighbourX, int neighbourY)
		{
		if (neighbourX < 0 || neighbourY < 0) {
			return true;
		}

		if (neighbourY >= board.length || neighbourX >= board[0].length) {
			return true;
		}
		
		return false;
	}

}
