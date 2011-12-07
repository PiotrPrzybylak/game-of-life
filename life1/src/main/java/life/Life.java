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
				int liveNeigbours = LiveNeigboursCounter.countLiveNeigbours(x, y, board);

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
