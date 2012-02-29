package life;

public class Life {

	World world;

	public void setInitialBoard(char[][] initialBoard) {
		
		Cell[][] newBoard = translateBoard(initialBoard);

		world  = new World(newBoard);
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
		world.evolve();
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
