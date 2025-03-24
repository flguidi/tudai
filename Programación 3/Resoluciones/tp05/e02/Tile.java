package tp05.e02;

public class Tile {

    private final int row;
    private final int col;
    private final int value;
    private final boolean north;
    private final boolean south;
    private final boolean east;
    private final boolean west;
    private boolean visited;

    public Tile(int row, int col, int value, boolean north, boolean south, boolean east, boolean west) {
        this.row = row;
        this.col = col;
        this.value = value;
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
        this.visited = false;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getValue() {
        return value;
    }

    public boolean canGoNorth() {
        return north;
    }

    public boolean canGoSouth() {
        return south;
    }

    public boolean canGoEast() {
        return east;
    }

    public boolean canGoWest() {
        return west;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "(" + row + "," + col + ") v=" + value;
    }

}
