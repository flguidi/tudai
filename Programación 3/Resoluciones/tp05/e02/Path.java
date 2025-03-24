package tp05.e02;

import java.util.ArrayList;
import java.util.List;

public class Path {

    private final List<Tile> tiles;
    private int totalValue;

    public Path() {
        tiles = new ArrayList<Tile>();
        totalValue = 0;
    }

    public int getTotalValue() {
        return totalValue;
    }

    public List<Tile> getTiles() {
        return new ArrayList<>(tiles);
    }

    public void addTile(Tile tile) {
        tiles.add(tile);
        totalValue += tile.getValue();
    }

    public void addAllTiles(List<Tile> tiles) {
        for (Tile tile : tiles) {
            addTile(tile);
        }
    }

    public void removeLastTile() {
        Tile lastTile = tiles.removeLast();
        totalValue -= lastTile.getValue();
    }

    public void clear() {
        tiles.clear();
        totalValue = 0;
    }

    @Override
    public String toString() {
        return "Camino más corto: " + tiles +
                "\nValor total: " + totalValue;
    }

}
