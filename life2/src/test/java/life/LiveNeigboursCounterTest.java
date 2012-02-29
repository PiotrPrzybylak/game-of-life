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
	
	@Test
	public void shouldCheckBoundaries()  {
		
		//given
		char[][] board = new char[][] {
				{'*','.','*'},
		};

		assertFalse(LiveNeigboursCounter.isOutOfBoardBound(Life.translateBoard(board), 0, 0));
		assertFalse(LiveNeigboursCounter.isOutOfBoardBound(Life.translateBoard(board), 1, 0));
		assertFalse(LiveNeigboursCounter.isOutOfBoardBound(Life.translateBoard(board), 2, 0));

		assertTrue(LiveNeigboursCounter.isOutOfBoardBound(Life.translateBoard(board), 1, 1));
		assertTrue(LiveNeigboursCounter.isOutOfBoardBound(Life.translateBoard(board), 0, 1));

		
		
	}
	

}
