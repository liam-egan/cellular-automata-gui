package ap.gui.grid;

import java.util.*;

public class ElementaryGridRule30 extends ElementaryGridRule {
        public boolean getNextCellState(int x, int y, Grid g) {
                List<Cell> topNeighbors = super.getTopNeighbors(x, y, g);
                Cell current = g.getCell(x, y);
                Cell left = topNeighbors.get(0);
                Cell middle = topNeighbors.get(1);
                Cell right = topNeighbors.get(2);

                return current.getEnabled() ||
                       (left.getEnabled() ^ (middle.getEnabled() || right.getEnabled()));
        }
    }
