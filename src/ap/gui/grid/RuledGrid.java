package ap.gui.grid;

import ap.gui.util.*;

public class RuledGrid extends StatefulGrid {
        protected GridRule rule; 
    
        public RuledGrid(GridRule rule) {
            this(1, 1, rule);
        }
    
        public RuledGrid(int width, int height, GridRule rule) {
            super(width, height);
            this.rule = rule;
        }

        public GridRule getRule() {
            return this.rule;
        }

        public void setRule(GridRule rule) {
            this.rule = rule;
        }
    
        public void update() {
            Cell[][] cells = new Cell[this.getHeight()][this.getWidth()];
            ArrayUtils.replaceNullWithNewObject(cells, Cell.class);
    
            for (int row = 0; row < this.getHeight(); row++) {
                for (int col = 0; col < this.getWidth(); col++) {
                    boolean nextCellState = this.rule.getNextCellState(col, row, this);
                    cells[row][col].setEnabled(nextCellState);
                }
            }
    
            super.next(cells);
        }
    }
