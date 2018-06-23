package ap.gui.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import ap.gui.grid.*;

import java.util.*;

public class GridTopControlPanel extends JPanel {
    public static final String STOP = "stop";
    public static final String START = "start";
    public static final String COMBO_CHANGED = "combo";
    public static final String COMBO_CONWAY = "Conway's Game of Life";
    public static final String COMBO_30 = "Elementary Rule 30";
    public static final String COMBO_60 = "Elementary Rule 60";
    public static final String COMBO_90 = "Elementary Rule 90";
    public static final String BACK = "back";
    public static final String NEXT = "next";

    public static Map<String, GridRule> COMBO_RULES;

    private JButton stop;
    private JButton start;
    private JComboBox rule;
    private JButton back;
    private JButton next;

    public GridTopControlPanel() {
        this.setLayout(new FlowLayout());
        
        String[] comboOptions = {COMBO_CONWAY, COMBO_30, COMBO_60, COMBO_90};

        this.stop = new JButton("Stop");
        this.start = new JButton("Start");
        this.rule = new JComboBox(comboOptions);
        this.rule.setSelectedIndex(0);
        this.back = new JButton("Back");
        this.next = new JButton("Next");

        this.stop.setActionCommand(GridTopControlPanel.STOP);
        this.start.setActionCommand(GridTopControlPanel.START);
        this.rule.setActionCommand(GridTopControlPanel.COMBO_CHANGED);
        this.back.setActionCommand(GridTopControlPanel.BACK);
        this.next.setActionCommand(GridTopControlPanel.NEXT);

        this.add(stop);
        this.add(start);
        this.add(rule);
        this.add(back);
        this.add(next);
    }

    static {
        COMBO_RULES = new HashMap<String, GridRule>();
        COMBO_RULES.put(COMBO_CONWAY, new ConwayGridRule());
        COMBO_RULES.put(COMBO_30, new ElementaryGridRule30());
        COMBO_RULES.put(COMBO_60, new ElementaryGridRule60());
        COMBO_RULES.put(COMBO_90, new ElementaryGridRule90());
    }

    public void addActionListener(ActionListener listener) {
        this.stop.addActionListener(listener);
        this.start.addActionListener(listener);
        this.rule.addActionListener(listener);
        this.back.addActionListener(listener);
        this.next.addActionListener(listener);
    }

    public void removeActionListener(ActionListener listener) {
        this.stop.removeActionListener(listener);
        this.start.removeActionListener(listener);
        this.rule.removeActionListener(listener);
        this.back.removeActionListener(listener);
        this.next.removeActionListener(listener);
    }
}
