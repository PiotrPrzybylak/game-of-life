package life;

import java.util.HashSet;

public class LiveCellWith2Neighbour implements Cell {
    private final Place place;

    public LiveCellWith2Neighbour(Place place) {
        this.place = place;
    }

    @Override
    public Cell addNeigbour() {
        return new LiveCellWith3Neighbour(place);
    }

    @Override
    public void addYourselfToNewWorld(HashSet<Place> newWorld) {
        newWorld.add(place);
    }
}
