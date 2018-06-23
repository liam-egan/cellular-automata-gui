package ap.gui.grid;

public interface GridRule {
    boolean getNextCellState(int x, int y, Grid g);
}
