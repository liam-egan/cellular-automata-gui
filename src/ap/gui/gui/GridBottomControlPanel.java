package ap.gui.gui;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GridBottomControlPanel extends JPanel {
    public static final String RESET = "reset";
    public static final String RANDOMIZE = "randomize";
    public static final String CELL_SIZE = "cell_size";
    public static final String DURATION = "duration";

    private JButton reset;
    private JButton randomize;
    private JTextField cellSize;
    private JTextField duration;
    private JLabel generationLabel;
    private int generation;

    public GridBottomControlPanel() {
        this.setLayout(new BorderLayout());

        this.reset = new JButton("Reset");
        this.randomize = new JButton("Randomize");
        this.cellSize = new JTextField("5");
        this.duration = new JTextField("100");

        this.reset.setActionCommand(GridBottomControlPanel.RESET);
        this.randomize.setActionCommand(GridBottomControlPanel.RANDOMIZE);
        this.cellSize.setActionCommand(GridBottomControlPanel.CELL_SIZE);
        this.duration.setActionCommand(GridBottomControlPanel.DURATION);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(this.reset);
        buttonPanel.add(this.randomize);

        JPanel cellSizePanel = new JPanel();
        JLabel cellSizeLabel = new JLabel("Cell Size:");
        cellSizePanel.add(cellSizeLabel);
        cellSizePanel.add(this.cellSize);

        JPanel durationPanel = new JPanel();
        JLabel durationLabel = new JLabel("Duration:");
        durationPanel.add(durationLabel);
        durationPanel.add(this.duration);

        this.generation = 0;
        this.generationLabel = new JLabel("Generation: " + this.generation, SwingConstants.CENTER);

        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(cellSizePanel, BorderLayout.WEST);
        this.add(durationPanel, BorderLayout.EAST);
        this.add(this.generationLabel, BorderLayout.CENTER);
    }

    public void addActionListener(ActionListener listener) {
        this.reset.addActionListener(listener);
        this.randomize.addActionListener(listener);
        this.cellSize.addActionListener(listener);
        this.duration.addActionListener(listener);
    }

    public void removeActionListener(ActionListener listener) {
        this.reset.removeActionListener(listener);
        this.randomize.removeActionListener(listener);
        this.cellSize.removeActionListener(listener);
        this.duration.removeActionListener(listener);
    }

    public int getGeneration() {
        return this.generation;
    }
    
    public void setGeneration(int generation) {
        this.generation = generation;
        this.generationLabel.setText("Generation: " + this.generation);
    }

    public void incrementGeneration() {
        this.setGeneration(this.generation + 1);
    }

    public void decrementGeneration() {
        if (this.generation > 0) {
            this.setGeneration(this.generation - 1);
        }
    }
}
