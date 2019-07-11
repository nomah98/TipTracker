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

}
