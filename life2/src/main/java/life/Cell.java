package life;

import java.util.ArrayList;
import java.util.List;

public class Cell {

	private final List<Cell> neigbours = new ArrayList<Cell>();
	
	private final char c;

	public Cell(char c) {
		this.c = c;
	}

	public char value() {
		return c;
	}

	public void addNeigbour(Cell cell) {
		neigbours.add(cell);
	}

}
