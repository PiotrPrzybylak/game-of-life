package life;

import java.util.HashSet;

public class DeadCellWith2Neighbours implements Cell {
    private final Place place;

    public DeadCellWith2Neighbours(Place place) {
        this.place = place;
    }

    @Override
    public Cell addNeigbour() {
        return new DeadCellWith3Neighbours(place);
    }

    @Override
    public void addYourselfToNewWorld(HashSet<Place> newWorld) {

    }
}
