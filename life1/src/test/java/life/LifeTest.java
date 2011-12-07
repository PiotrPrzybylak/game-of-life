package life;

import static org.junit.Assert.*;

import org.junit.Test;


public class LifeTest {
	
	@Test
	public void noCellShouldBeBornOnEmptyBoard() {
		// given
		Life life = new Life();
		life.setInitialBoard(new char[][] {
				{'.','.','.'},
				{'.','.','.'},
				{'.','.','.'},
		});
		
		// when
		life.evolve();
				
		// then
		assertArrayEquals(new char[][] {
				{'.','.','.'},
				{'.','.','.'},
				{'.','.','.'},
		}, life.getCurrentBoard());
	}
	
	@Test
	public void newCellShouldBeBornFromThreeNeigbours() {
		// given
		Life life = new Life();
		life.setInitialBoard(new char[][] {
				{'*','.','*'},
				{'.','.','.'},
				{'.','*','.'},
		});
		
		// when
		life.evolve();
				
		// then
		assertArrayEquals(new char[][] {
				{'.','.','.'},
				{'.','*','.'},
				{'.','.','.'},
		}, life.getCurrentBoard());
	}

}
