package life;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class Place {
    private final int rowNumber;
    private final int columnNumber;

    public Place(int rowNumber, int columnNumber) {

        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Place place = (Place) o;

        if (columnNumber != place.columnNumber) return false;
        if (rowNumber != place.rowNumber) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowNumber;
        result = 31 * result + columnNumber;
        return result;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public void evolve(Set<Place> world, HashSet<Place> newWorld) {
        final HashSet<Place> placesForNeighbours = new HashSet<Place>();
        placesForNeighbours.add(new Place(rowNumber - 1, columnNumber - 1));
        placesForNeighbours.add(new Place(rowNumber - 1, columnNumber));
        placesForNeighbours.add(new Place(rowNumber - 1, columnNumber + 1));
        placesForNeighbours.add(new Place(rowNumber, columnNumber - 1));
        placesForNeighbours.add(new Place(rowNumber, columnNumber + 1));
        placesForNeighbours.add(new Place(rowNumber + 1, columnNumber - 1));
        placesForNeighbours.add(new Place(rowNumber + 1, columnNumber));
        placesForNeighbours.add(new Place(rowNumber + 1, columnNumber + 1));

        final Collection<Place> neighbours = CollectionUtils.intersection(world, placesForNeighbours);
        Cell cell = new LiveCellWith0Neighbours(this);
        for (Place neighbour : neighbours) {
            cell = cell.addNeigbour();
        }
        cell.addYourselfToNewWorld(newWorld);
    }
}
