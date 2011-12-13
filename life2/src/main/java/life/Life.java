package life;

public class Life {

	private char[][] board;

	public void setInitialBoard(char[][] initialBoard) {
		this.board = initialBoard;
	}

	public void evolve() {
		char[][] newBoard = new char[board.length][board[0].length];

		for (int y = 0; y < board.length; y++) {
			char[] row = board[y];
			interateColumns(newBoard, y, row);
		}

		board = newBoard;

	}

	private void interateColumns(char[][] newBoard, int y, char[] row) {
		for (int x = 0; x < row.length; x++) {
			int liveNeigbours = LiveNeigboursCounter.countLiveNeigbours(x, y, board);
			newBoard[y][x] = '.';			
			spawnCellToLife(newBoard, y, x, liveNeigbours);			
			leaveCellAlive(newBoard, y, x, liveNeigbours);
		}
	}

	private void leaveCellAlive(char[][] newBoard, int y, int x, int liveNeigbours) {
		if (liveNeigbours == 2 && board[y][x] == '*') {
			newBoard[y][x] = '*';
		}
	}

	private void spawnCellToLife(char[][] newBoard, int y, int x, int liveNeigbours) {
		if (liveNeigbours == 3) {
			newBoard[y][x] = '*';
		}
	}

	public Object[] getCurrentBoard() {
		return board;
	}

}
