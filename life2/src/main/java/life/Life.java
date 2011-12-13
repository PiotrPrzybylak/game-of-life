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
			interateColumns(newBoard, new RowNumber(y), row);
		}

		board = newBoard;

	}

	private void interateColumns(char[][] newBoard, RowNumber y, char[] row) {
		for (int x = 0; x < row.length; x++) {
			int liveNeigbours = LiveNeigboursCounter.countLiveNeigbours(x, y, board);
			newBoard[y.getValue()][x] = '.';			
			spawnCellToLife(newBoard, y, new ColumnNumber(x), new LiveNeigboursNumber(liveNeigbours));			
			leaveCellAlive(newBoard, y, new ColumnNumber(x), new LiveNeigboursNumber(liveNeigbours));
		}
	}

	private void leaveCellAlive(char[][] newBoard, RowNumber y, ColumnNumber x, LiveNeigboursNumber liveNeigbours) {
		if (liveNeigbours.getValue() == 2 && board[y.getValue()][x.getValue()] == '*') {
			newBoard[y.getValue()][x.getValue()] = '*';
		}
	}

	private void spawnCellToLife(char[][] newBoard, RowNumber y, ColumnNumber x, LiveNeigboursNumber liveNeigbours) {
		if (liveNeigbours.getValue() == 3) {
			newBoard[y.getValue()][x.getValue()] = '*';
		}
	}

	public Object[] getCurrentBoard() {
		return board;
	}

}
