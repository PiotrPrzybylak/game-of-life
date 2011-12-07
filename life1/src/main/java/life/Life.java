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
			}
		}

		if (containsLife(board)) {
			board = new char[][] {
					{ '.', '.', '.' },
					{ '.', '*', '.' },
					{ '.', '.', '.' } };
		}

	}

	private int countLiveNeigbours(int x, int y, char[][] board) {
		for (NeigbourgPosition neigbourgPosition : NeigbourgPosition.values()) {
			int neigbourX = x + neigbourgPosition.getX();
			int neigbourY = y + neigbourgPosition.getY();
			if (neigbourX < 0 || neigbourY < 0) {
				continue;
			}
			
			if (neigbourY >= board.length || neigbourX >= board[0].length) {
				continue;
			}
			
			if (board[neigbourY][ neigbourX] == '*') {
				
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
