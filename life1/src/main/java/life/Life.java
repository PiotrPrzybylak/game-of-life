package life;

public class Life {

	private char[][] initialBoard;

	public void setInitialBoard(char[][] initialBoard) {
		this.initialBoard = initialBoard;		
	}

	public void evolve() {
		// TODO Auto-generated method stub
		
	}

	public Object[] getCurrentBoard() {
		
		if (containsLife(initialBoard)) {
			return new char[][] {
					{'.','.','.'},
					{'.','*','.'},
					{'.','.','.'}};
		}
		
		return new char[][] {
				{'.','.','.'},
				{'.','.','.'},
				{'.','.','.'}};
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
