package ap.gui.grid;

import ap.gui.util.*;

public class StatefulGrid extends Grid {
        protected Stack<Cell[][]> history;
    
        public StatefulGrid() {
            this(1, 1);
        }
    
        public StatefulGrid(int width, int height) {
            super(width, height);
            this.history = new Stack<Cell[][]>();
        }
    
        public void next(Cell[][] cells) {
            this.history.push(this.cells);
            this.cells = cells;
        }
    
        public void prev() {
            if (!this.history.isEmpty()) {
                this.cells = this.history.pop();
            }
        }

        public void reset() {
            this.history.clear();

            Cell[][] cells = new Cell[super.getHeight()][super.getWidth()];
            ArrayUtils.replaceNullWithNewObject(cells, Cell.class);

            this.cells = cells;
        }

        public void randomize() {
            this.reset();

            int numOfCellsToCreate = (int) (Math.random() * super.getWidth() * super.getHeight());
            for (int i = 0; i < numOfCellsToCreate; i++) {
                int x = (int) (Math.random() * super.getWidth());
                int y = (int) (Math.random() * super.getHeight());
                super.addCell(x, y);
            }
        }
    }
