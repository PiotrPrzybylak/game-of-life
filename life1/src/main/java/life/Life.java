package life;

public class Life {

	private char[][] board;

	public void setInitialBoard(char[][] initialBoard) {
		this.board = initialBoard;
	}

	public void evolve() {
		char[][] newBoard = board.clone();

		for (int y = 0; y < board.length; y++) {
			char[] row = board[y];
			for (int x = 0; x < row.length; x++) {
				int liveNeigbours = countLiveNeigbours(x, y, board);

				newBoard[y][x] = '.';
				
				if (liveNeigbours == 3) {
					newBoard[y][x] = '*';
				}
				
				if (liveNeigbours == 2 && board[y][x] == '*') {
					newBoard[y][x] = '*';
				}
			}
		}

		board = newBoard;

	}

	private int countLiveNeigbours(int x, int y, char[][] board) {
		int liveNeighbours = 0;
		for (NeighbourgPosition neighbourgPosition : NeighbourgPosition.values()) {
			int neighbourX = x + neighbourgPosition.getX();
			int neighbourY = y + neighbourgPosition.getY();
			if (neighbourX < 0 || neighbourY < 0) {
				continue;
			}

			if (neighbourY >= board.length || neighbourX >= board[0].length) {
				continue;
			}

			if (board[neighbourY][neighbourX] == '*') {
				liveNeighbours++;
			}
		}
		return 0;
	}

	public Object[] getCurrentBoard() {
		return board;
	}

	private boolean containsLife(char[][] board) {
		for (char[] row : board) {
			for (char cell : row) {
				if (cell == '*') {
					return true;
				}
			}
		}
		return false;
	}

}
