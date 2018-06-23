package ap.gui.grid;

import java.util.*;

public class ConwayGridRule implements GridRule {
        public boolean getNextCellState(int x, int y, Grid g) {
                List<Cell> enabledNeighbors = this.getEnabledNeighbors(x, y, g);
                boolean currentCellState = g.getCell(x, y).getEnabled();
                int size = enabledNeighbors.size();

                return  (!currentCellState && size == 3) ||
                        (currentCellState && (size == 2 || size == 3));
        }
    
        private List<Cell> getEnabledNeighbors(int x, int y, Grid g) {
            List<Cell> enabledNeighbors = new ArrayList<Cell>();

            int[][] offsets = {{-1, -1}, {0, -1}, {1, -1}, 
                               {-1, 0},           {1, 0},
                               {-1, 1},  {0, 1},  {1, 1}};

            for (int[] offset : offsets) {
                Cell c = this.getNeighbor(x + offset[0], y + offset[1], g);
                if (c != null && c.getEnabled()) {
                    enabledNeighbors.add(c);
                }
            }
            
            return enabledNeighbors;
        }
    
        private Cell getNeighbor(int x, int y, Grid g) {
            Cell c = null;
            
            try {
                c = g.getCell(x, y);
            } catch (IndexOutOfBoundsException e) {}
    
            return c;
        }
    }
