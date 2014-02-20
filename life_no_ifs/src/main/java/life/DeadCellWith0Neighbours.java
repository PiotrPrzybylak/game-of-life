package life;

import java.util.HashSet;

public class DeadCellWith0Neighbours implements Cell {
    private final Place place;

    public DeadCellWith0Neighbours(Place place) {
        this.place = place;
    }

    @Override
    public Cell addNeigbour() {
        return new DeadCellWith1Neighbour(place);
    }

    @Override
    public void addYourselfToNewWorld(HashSet<Place> newWorld) {

    }
}
