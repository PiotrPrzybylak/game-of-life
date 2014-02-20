package life;

import java.util.HashSet;

public class LiveCellWith2Neighbours implements Cell {
    private final Place place;

    public LiveCellWith2Neighbours(Place place) {
        this.place = place;
    }

    @Override
    public Cell addNeigbour() {
        return new LiveCellWith3Neighbours(place);
    }

    @Override
    public void addYourselfToNewWorld(HashSet<Place> newWorld) {
        newWorld.add(place);
    }
}
