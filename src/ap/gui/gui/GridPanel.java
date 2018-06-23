package ap.gui.gui;

import ap.gui.grid.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GridPanel extends JPanel implements MouseListener {
    private static final int DEFAULT_CELL_SIZE = 15;
    protected Grid grid;
    protected int cellSize;
    
    public GridPanel() {
        this(new Grid());
    }
    
    public GridPanel(Grid grid) {
        this(grid, DEFAULT_CELL_SIZE);
    }
    
    public GridPanel(Grid grid, int cellSize) {
        this.addMouseListener(this);
        this.grid = grid;
        this.cellSize = cellSize;
    }
    
    public Grid getGrid() {
        return this.grid;
    }

    public void setGrid(Grid g) {
        this.grid = g;
    }
    
    public int getCellSize() {
        return this.cellSize;
    }

    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }
    
    public void paintComponent(Graphics g) {
        this.setSize(this.grid.getWidth() * this.cellSize + 1, this.grid.getHeight() * this.cellSize + 1);
        
        for (int row = 0; row < this.getHeight() - 1; row += this.cellSize) {
            for (int col = 0; col < this.getWidth() - 1; col += this.cellSize) {
                g.drawRect(col, row, this.cellSize, this.cellSize);
                if (this.grid.getCell(col / this.cellSize, row / this.cellSize).getEnabled()) {
                    g.fillRect(col, row, this.cellSize, this.cellSize);
                }
            }
        }
    }
    
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        
        this.grid.toggleCell(x / this.cellSize, y / this.cellSize);
        this.repaint();
    }
    
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
