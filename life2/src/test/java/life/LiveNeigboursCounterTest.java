package life;

import static org.junit.Assert.*;

import org.junit.Test;


public class LiveNeigboursCounterTest {
	
	@Test
	public void shouldCountLiveNeigbours()  {
		
		//given
		char[][] board = new char[][] {
				{'*','.','*'},
				{'.','.','.'},
				{'.','*','.'},
		};
		
		
		// when
		int liveNeigbours = LiveNeigboursCounter.countLiveNeigbours(new ColumnNumber(1), new RowNumber(1), Life.translateBoard(board));
		
		// then
		assertEquals(3, liveNeigbours);
		
	}

}
