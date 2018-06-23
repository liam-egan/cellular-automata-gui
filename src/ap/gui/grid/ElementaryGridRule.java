package ap.gui.grid;

import java.util.*;

public abstract class ElementaryGridRule implements GridRule {
        public abstract boolean getNextCellState(int x, int y, Grid g);

        protected List<Cell> getTopNeighbors(int x, int y, Grid g) {
            List<Cell> topNeighbors = new ArrayList<Cell>();

            int[][] offsets = {{-1, -1}, {0, -1}, {1, -1}};

            for (int[] offset : offsets) {
                Cell c = this.getNeighbor(x + offset[0], y + offset[1], g);
                if (c == null) c = new Cell(false);
                topNeighbors.add(c);
            }
            
            return topNeighbors;
        }
    
        protected Cell getNeighbor(int x, int y, Grid g) {
            Cell c = null;
            
            try {
                c = g.getCell(x, y);
            } catch (IndexOutOfBoundsException e) {}
    
            return c;
        }
    }
