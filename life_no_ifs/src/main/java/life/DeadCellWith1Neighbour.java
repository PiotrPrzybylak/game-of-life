package life;

import java.util.HashSet;

public class DeadCellWith1Neighbour implements Cell {
    private final Place place;

    public DeadCellWith1Neighbour(Place place) {
        this.place = place;
    }

    @Override
    public Cell addNeigbour() {
        return new DeadCellWith2Neighbours(place);
    }

    @Override
    public void addYourselfToNewWorld(HashSet<Place> newWorld) {

    }
}
