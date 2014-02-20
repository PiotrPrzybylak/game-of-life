package life;

import java.util.HashSet;

public class LiveCellWith3Neighbours implements Cell {
    private final Place place;

    public LiveCellWith3Neighbours(Place place) {
        this.place = place;
    }

    @Override
    public Cell addNeigbour() {
        return new OvercrowdedCell();
    }

    @Override
    public void addYourselfToNewWorld(HashSet<Place> newWorld) {
        newWorld.add(place);
    }
}
