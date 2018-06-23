package ap.gui.gui;

import ap.gui.grid.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GridFrame extends JFrame implements ActionListener {
    private GridPanel gridPanel;
    private GridBottomControlPanel gridBottomControlPanel;
    private Timer timer;
    private GridRule rule;
    private int cellSize;

    public GridFrame() {
        this.setTitle("Cellular Automata");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        this.rule = new ConwayGridRule();
        this.cellSize = 5;

        GridTopControlPanel gridTopControlPanel = new GridTopControlPanel();
        gridTopControlPanel.addActionListener(this);
        this.add(gridTopControlPanel, BorderLayout.NORTH);

        this.gridBottomControlPanel = new GridBottomControlPanel();
        gridBottomControlPanel.addActionListener(this);
        this.add(gridBottomControlPanel, BorderLayout.SOUTH);

        RuledGrid grid = new RuledGrid(240, 150, this.rule);
        this.gridPanel = new GridPanel(grid, this.cellSize);
        this.add(gridPanel, BorderLayout.CENTER);

        this.timer = new Timer(100, this);
        this.timer.setActionCommand(GridTopControlPanel.NEXT);

        this.setSize(240 * this.cellSize, 150 * this.cellSize + 150);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case GridTopControlPanel.NEXT:
                ((RuledGrid) this.gridPanel.getGrid()).update();
                this.gridBottomControlPanel.incrementGeneration();
                break;

            case GridTopControlPanel.BACK:
                ((StatefulGrid) this.gridPanel.getGrid()).prev();
                this.gridBottomControlPanel.decrementGeneration();
                break;

            case GridTopControlPanel.START:
                this.timer.start();
                break;

            case GridTopControlPanel.STOP:
                this.timer.stop();
                break;

            case GridTopControlPanel.COMBO_CHANGED:
                JComboBox comboSource = (JComboBox) e.getSource();
                String selectedRule = (String) comboSource.getSelectedItem();
                GridRule newRule = GridTopControlPanel.COMBO_RULES.get(selectedRule);
                ((RuledGrid) this.gridPanel.getGrid()).setRule(newRule);
                break;
            
            case GridBottomControlPanel.RESET:
                ((StatefulGrid) this.gridPanel.getGrid()).reset();
                this.gridBottomControlPanel.setGeneration(0);
                break;
            
            case GridBottomControlPanel.RANDOMIZE:
                ((StatefulGrid) this.gridPanel.getGrid()).randomize();
                this.gridBottomControlPanel.setGeneration(0);
                break;
            
            case GridBottomControlPanel.DURATION:
                try {
                    JTextField source = (JTextField) e.getSource();
                    this.timer.setDelay(Integer.parseInt(source.getText()));
                } catch (Exception ex) {}
                break;

            case GridBottomControlPanel.CELL_SIZE:
                try {
                    JTextField source = (JTextField) e.getSource();
                    int cellSize = Integer.parseInt(source.getText());
                    this.gridPanel.setCellSize(cellSize);
                    this.setSize(240 * cellSize, 150 * cellSize + 150);
                    this.cellSize = cellSize;
                } catch (Exception ex) {}
                break;
        }

        this.repaint();
    }
}
