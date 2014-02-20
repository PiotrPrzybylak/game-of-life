package life;

import java.util.HashSet;

public class LiveCellWith3Neighbour implements Cell {
    private final Place place;

    public LiveCellWith3Neighbour(Place place) {
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
