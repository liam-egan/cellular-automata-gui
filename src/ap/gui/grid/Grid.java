package ap.gui.grid;

import java.util.*;
import ap.gui.util.*;

public class Grid {
        protected int width;
        protected int height;
        protected Cell[][] cells;
    
        public Grid() {
            this(1, 1);
        }
    
        public Grid(int width, int height) {
            Cell[][] cells = new Cell[height][width];
            ArrayUtils.replaceNullWithNewObject(cells, Cell.class);
    
            this.width = width;
            this.height = height;
            this.cells = cells;
        }
    
        public int getWidth() {
            return this.width;
        }

        public void setWidth(int width) {
            for (int row = 0; row < this.height; row++) {
                Cell[] cellsRow = Arrays.copyOf(this.cells[row], width);
                ArrayUtils.replaceNullWithNewObject(cellsRow, Cell.class);
                this.cells[row] = cellsRow;
            }
        }
    
        public int getHeight() {
            return this.height;
        }

        public void setHeight(int height) {
            Cell[][] cells = Arrays.copyOf(this.cells, height);
            ArrayUtils.replaceNullWithNewObject(cells, Cell.class);
            this.cells = cells;
        }
    
        public void addCell(Position p) {
            this.addCell(p.getX(), p.getY());
        }
    
        public void addCell(int x, int y) {
            this.setCellEnabled(x, y, true);
        }
    
        public void removeCell(Position p) {
            this.removeCell(p.getX(), p.getY());
        }
    
        public void removeCell(int x, int y) {
            this.setCellEnabled(x, y, false);
        }
    
        public Cell getCell(Position p) {
            return this.getCell(p.getX(), p.getY());
        }
    
        public Cell getCell(int x, int y) throws IndexOutOfBoundsException {
            this.throwIfOutsideBoundaries(x, y);
            return this.cells[y][x];
        }
    
        public void toggleCell(Position p) {
            this.toggleCell(p.getX(), p.getY());
        }
    
        public void toggleCell(int x, int y) {
            this.throwIfOutsideBoundaries(x, y);
            this.cells[y][x].toggleEnabled();
        }
    
        public void setCellEnabled(Position p, boolean enabled) {
            this.setCellEnabled(p.getX(), p.getY(), enabled);
        }
    
        public void setCellEnabled(int x, int y, boolean enabled) {
            this.throwIfOutsideBoundaries(x, y);
            this.cells[y][x].setEnabled(enabled);
        }
    
        protected void throwIfOutsideBoundaries(Position p) {
            this.throwIfOutsideBoundaries(p.getX(), p.getY());
        }
    
        protected void throwIfOutsideBoundaries(int x, int y) {
            this.throwIfOutsideBoundaries(x, y, true, true);
        }
    
        protected void throwIfOutsideBoundaries(Position p, boolean testX, boolean testY) {
            this.throwIfOutsideBoundaries(p.getX(), p.getY(), testX, testY);
        }
    
        protected void throwIfOutsideBoundaries(int x, int y, boolean testX, boolean testY) throws IndexOutOfBoundsException {
            if (testX && (x >= this.width || x < 0)) {
                    throw new IndexOutOfBoundsException("X is out of range");
            }
            if (testY && (y >= this.height || y < 0)) {
                    throw new IndexOutOfBoundsException("Y is out of range");
            }
        }
    
        public String toString() {
            String result = "";
    
            for (Cell[] row : cells) {
                for (Cell c : row) {
                    result += c + " ";
                }
    
                result += "\n";
            }
    
            return result;
        }
    }
