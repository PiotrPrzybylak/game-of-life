package life;

public class Life {

	private char[][] board;

	public void setInitialBoard(char[][] initialBoard) {
		this.board = initialBoard;		
	}

	public void evolve() {
		if (containsLife(board)) {
			board = new char[][] {
					{'.','.','.'},
					{'.','*','.'},
					{'.','.','.'}};
		}
		
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
