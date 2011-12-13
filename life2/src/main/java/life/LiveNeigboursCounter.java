package life;

public class LiveNeigboursCounter {

	static int countLiveNeigbours(int x, int y, char[][] board) {
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
		return liveNeighbours;
	}

}
