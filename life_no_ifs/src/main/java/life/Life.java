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
        return null;
    }

    public void evolve() {

    }
}
