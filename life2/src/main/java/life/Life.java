package life;

public class Life {

	private World world = new World();

	public void setInitialBoard(char[][] initialBoard) {
		
		Cell[][] newBoard = translateBoard(initialBoard);

		world.board = newBoard;
	}

	public static Cell[][] translateBoard(char[][] initialBoard) {
		Cell[][] newBoard = new Cell[initialBoard.length][initialBoard[0].length];

		for (int y = 0; y < initialBoard.length; y++) {
			char[] row = initialBoard[y];
			createColums(newBoard, new RowNumber(y), row);
		}
		return newBoard;
	}

	private static void createColums(Cell[][] newBoard, RowNumber rowNumber, char[] row) {
		for (int x = 0; x < row.length; x++) {
			newBoard[rowNumber.getValue()][x] = new Cell(row[x]);
		}
	}

	public void evolve() {
		Cell[][] newBoard = new Cell[world.board.length][world.board[0].length];

		for (int y = 0; y < world.board.length; y++) {
			Cell[] row = world.board[y];
			interateColumns(newBoard, new RowNumber(y), row);
		}

		world.board = newBoard;

	}

	private void interateColumns(Cell[][] newBoard, RowNumber y, Cell[] row) {
		for (int x = 0; x < row.length; x++) {
			int liveNeigbours = LiveNeigboursCounter.countLiveNeigbours(new ColumnNumber(x), y, world.board);
			newBoard[y.getValue()][x] = new Cell('.');			
			spawnCellToLife(newBoard, y, new ColumnNumber(x), new LiveNeigboursNumber(liveNeigbours));			
			leaveCellAlive(newBoard, y, new ColumnNumber(x), new LiveNeigboursNumber(liveNeigbours));
		}
	}

	private void leaveCellAlive(Cell[][] newBoard, RowNumber y, ColumnNumber x, LiveNeigboursNumber liveNeigbours) {
		if (liveNeigbours.getValue() == 2 && world.board[y.getValue()][x.getValue()].value() == '*') {
			newBoard[y.getValue()][x.getValue()] = new Cell('*');
		}
	}

	private void spawnCellToLife(Cell[][] newBoard, RowNumber y, ColumnNumber x, LiveNeigboursNumber liveNeigbours) {
		if (liveNeigbours.getValue() == 3) {
			newBoard[y.getValue()][x.getValue()] = new Cell('*');
		}
	}

	public char[][] getCurrentBoard() {
		return translateBoard(world.board);
	}

	private char[][] translateBoard(Cell[][] board2) {
		char[][] newBoard = new char[board2.length][board2[0].length];

		for (int y = 0; y < board2.length; y++) {
			Cell[] row = board2[y];
			createColums(newBoard, new RowNumber(y), row);
		}
		return newBoard;
	}

	private void createColums(char[][] newBoard, RowNumber rowNumber, Cell[] row) {
		for (int x = 0; x < row.length; x++) {
			newBoard[rowNumber.getValue()][x] = row[x].value();
		}		
	}

}
