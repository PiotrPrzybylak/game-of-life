package life;

public enum NeighbourgPosition {
	UP_LEFT(-1, -1), UP_MIDDLE(0, -1), UP_RIGHT(1, -1),
	MIDDLE_LEFT(-1, 0), MIDDLE_RIGT(1, 0),
	DOWN_LEFT(-1, 1), DOWN_MIDDLE(0, 1), DOWN_RIGHT(1,1);

	private final int x;
	private final int y;

	private NeighbourgPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	
}
