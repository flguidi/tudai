package tp06.e09;

import java.util.ArrayList;
import java.util.List;

public class MaxCostPath {

    private List<int[]> cells;
    private int cost;

    public MaxCostPath() {
        cells = new ArrayList<>();
        cost = 0;
    }

    public void addCell(int[] cell, int cost) {
        cells.add(cell);
        this.cost += cost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Camino: ");
        for (int[] cell : cells) {
            sb.append("(").append(cell[0]).append(",").append(cell[1]).append(") ");
        }
        sb.append("\nCosto: ").append(this.cost).append("\n");
        return sb.toString();
    }

}
