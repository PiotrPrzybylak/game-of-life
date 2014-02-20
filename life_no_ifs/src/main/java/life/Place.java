package life;

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
}
