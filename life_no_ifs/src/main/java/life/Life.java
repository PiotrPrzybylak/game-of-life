package life;

import java.util.HashSet;
import java.util.Set;

public class Life {

    Set<Place> world = new HashSet<Place>();


    public void setInitialBoard(char[][] initalWorld) {
        for (int rowNumber = 0; rowNumber < initalWorld.length;  rowNumber++) {
            char[] row = initalWorld[rowNumber];
            for (int columnNumber = 0; columnNumber < row.length; columnNumber++) {

                char cell = initalWorld[rowNumber][columnNumber];
                if (cell == '*') {
                    world.add(new Place(rowNumber, columnNumber));
                }
            }
        }

    }

    public char[][] getCurrentBoard() {
        char[][] board = new char[3][3];
        for (int rowNumber = 0; rowNumber < board.length;  rowNumber++) {
            char[] row = board[rowNumber];
            for (int columnNumber = 0; columnNumber < row.length; columnNumber++) {
                board[rowNumber][columnNumber] = '.';
            }
        }


        for (Place place : world) {
            board[place.getRowNumber()][place.getColumnNumber()]='*';
        }
        return board;
    }

    public void evolve() {
        final HashSet<Place> newWorld = new HashSet<Place>();
        for(Place cell: world) {
            cell.evolve(world, newWorld);
        }
        world = newWorld;
    }
}
