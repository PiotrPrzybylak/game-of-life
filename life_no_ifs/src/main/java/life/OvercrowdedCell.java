package life;

import java.util.HashSet;

public class OvercrowdedCell implements Cell {
    @Override
    public Cell addNeigbour() {
        return this;
    }

    @Override
    public void addYourselfToNewWorld(HashSet<Place> newWorld) {

    }
}
