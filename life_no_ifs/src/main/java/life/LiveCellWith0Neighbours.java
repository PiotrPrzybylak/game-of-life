package life;

import java.util.HashSet;

public class LiveCellWith0Neighbours implements Cell {
    private final Place place;

    public LiveCellWith0Neighbours(Place place) {
        this.place = place;
    }

    public Cell addNeigbour() {
        return new LiveCellWith1Neighbour(place);
    }

    @Override
    public void addYourselfToNewWorld(HashSet<Place> newWorld) {
    }
}
