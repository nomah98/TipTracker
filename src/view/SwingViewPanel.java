package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SwingViewPanel extends JPanel {

    ArrayList<ShiftDisplay> shiftDisplays;

    public SwingViewPanel(ArrayList<ShiftDisplay> shiftDisplays) {
        super();
        this.setBackground(Color.CYAN);
        this.shiftDisplays = shiftDisplays;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
    }

}
