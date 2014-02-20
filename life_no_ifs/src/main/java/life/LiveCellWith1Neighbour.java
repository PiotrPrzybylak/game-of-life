package life;

import java.util.HashSet;

public class LiveCellWith1Neighbour implements Cell {
    private final Place place;

    public LiveCellWith1Neighbour(Place place) {
        this.place = place;
    }

    @Override
    public Cell addNeigbour() {
        return new LiveCellWith2Neighbours(place);
    }

    @Override
    public void addYourselfToNewWorld(HashSet<Place> newWorld) {

    }
}
