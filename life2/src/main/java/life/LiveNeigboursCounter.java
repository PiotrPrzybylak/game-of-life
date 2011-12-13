package life;

public class LiveNeigboursCounter {

	static int countLiveNeigbours(int x, RowNumber y, char[][] board) {
		int liveNeighbours = 0;
		for (NeighbourgPosition neighbourgPosition : NeighbourgPosition.values()) {
			int neighbourX = x + neighbourgPosition.getX();
			int neighbourY = y.getValue() + neighbourgPosition.getY();
			liveNeighbours = increamentCounterIfNeighbourIsAlive(board, liveNeighbours, neighbourX, neighbourY);
		}
		return liveNeighbours;
	}

	private static int increamentCounterIfNeighbourIsAlive(char[][] board, int liveNeighbours, int neighbourX,
			int neighbourY) {
		boolean outOfBoardBound = isOutOfBoardBound(board, neighbourX, neighbourY);
		if (outOfBoardBound) {
			return liveNeighbours;
		}

		if (board[neighbourY][neighbourX] == '*') {
			liveNeighbours++;
		}
		return liveNeighbours;
	}

	private static boolean isOutOfBoardBound(char[][] board, int neighbourX, int neighbourY)
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
