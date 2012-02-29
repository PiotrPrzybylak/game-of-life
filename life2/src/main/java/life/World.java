package life;

import static life.LiveNeigboursCounter.isOutOfBoardBound;

public class World {
	public Cell[][] board;

	public World(Cell[][] board) {
		this.board = board;
		setNeigbours(board);
	}

	private static void setNeigbours(Cell[][] board) {
		for (int y = 0; y < board.length; y++) {
			Cell[] row = board[y];
			setNeigboursInRow(board, new RowNumber(y), row);
			
		}
	}

	private static void setNeigboursInRow(Cell[][] board, RowNumber rowNumber,
			Cell[] row) {
		for (int x = 0; x < row.length; x++) {
			setNeigboursForCell(new ColumnNumber(x), rowNumber, board);

		}
		
	}

	private static void setNeigboursForCell(ColumnNumber x,
			RowNumber y, Cell[][] board) {
		for (NeighbourgPosition neighbourgPosition : NeighbourgPosition.values()) {
			int neighbourX = x.getValue() + neighbourgPosition.getX();
			int neighbourY = y.getValue() + neighbourgPosition.getY();
			addNeigbour(x, y, board, neighbourX, neighbourY);
		}
		
		
	}

	private static void addNeigbour(ColumnNumber x, RowNumber y,
			Cell[][] board, int neighbourX, int neighbourY) {
		if (!isOutOfBoardBound(board, neighbourX, neighbourY)) {
			Cell cell = board[y.getValue()][x.getValue()];
			cell.addNeigbour(board[neighbourY][neighbourX]);				
		}
	}

	public void evolve() {
		Cell[][] newBoard = new Cell[board.length][board[0].length];
	
		for (int y = 0; y < board.length; y++) {
			Cell[] row = board[y];
			interateColumns(newBoard, new RowNumber(y), row);
			
		}
		board = newBoard;
	
	}

	void interateColumns(Cell[][] newBoard, RowNumber y, Cell[] row) {
		for (int x = 0; x < row.length; x++) {
			int liveNeigbours = LiveNeigboursCounter.countLiveNeigbours(new ColumnNumber(x), y, board);
			newBoard[y.getValue()][x] = new Cell('.');			
			spawnCellToLife(newBoard, y, new ColumnNumber(x), new LiveNeigboursNumber(liveNeigbours));			
			leaveCellAlive(newBoard, board, y, new ColumnNumber(x), new LiveNeigboursNumber(liveNeigbours));
		}
	}

	static void spawnCellToLife(Cell[][] newBoard, RowNumber y, ColumnNumber x, LiveNeigboursNumber liveNeigbours) {
		if (liveNeigbours.getValue() == 3) {
			newBoard[y.getValue()][x.getValue()] = new Cell('*');
		}
	}

	static void leaveCellAlive(Cell[][] newBoard, Cell[][] oldBoard, RowNumber y, ColumnNumber x, LiveNeigboursNumber liveNeigbours) {
		if (liveNeigbours.getValue() == 2 && oldBoard[y.getValue()][x.getValue()].value() == '*') {
			newBoard[y.getValue()][x.getValue()] = new Cell('*');
		}
	}
}