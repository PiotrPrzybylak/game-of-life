package life;

import java.util.HashSet;

public interface Cell {
    Cell addNeigbour();

    void addYourselfToNewWorld(HashSet<Place> newWorld);
}
