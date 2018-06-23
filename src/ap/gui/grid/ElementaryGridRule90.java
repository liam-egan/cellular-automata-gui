package ap.gui.grid;

import java.util.*;

public class ElementaryGridRule90 extends ElementaryGridRule {
        public boolean getNextCellState(int x, int y, Grid g) {
                List<Cell> topNeighbors = super.getTopNeighbors(x, y, g);
                Cell current = g.getCell(x, y);
                boolean left = topNeighbors.get(0).getEnabled();
                boolean middle = topNeighbors.get(1).getEnabled();
                boolean right = topNeighbors.get(2).getEnabled();

                return current.getEnabled() ||
                       (left && middle && !right) ||
                       (left && !middle && !right) ||
                       (!left && middle && right) ||
                       (!left && !middle && right);
        }
    }
