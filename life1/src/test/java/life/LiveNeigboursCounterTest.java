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
		int liveNeigbours = LiveNeigboursCounter.countLiveNeigbours(1, 1, board);
		
		// then
		assertEquals(3, liveNeigbours);
		
	}

}
