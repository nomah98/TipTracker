package view;

import model.ITipModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SwingView extends JFrame implements MainView {

    private SwingViewPanel panel;

    private ArrayList<ShiftDisplay> displays;

    public SwingView(ITipModel model) {
        super();

        this.setTitle("TipTracker!!!");

        this.panel = new SwingViewPanel(displays);

        this.displays = model.setShifts();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(panel, BorderLayout.CENTER);

        this.setPreferredSize(new Dimension(1000, 1000));
    }

    @Override
    public void setButtonListeners(ActionListener listener) {

    }

    @Override
    public JList<String> getTippers() {
        return null;
    }

    @Override
    public DefaultListModel<String> getTippersModel() {
        return null;
    }

    @Override
    public String getFilePathInput() {
        return null;
    }

    @Override
    public void setErrorMessage(String message) {

    }

    @Override
    public String createView() {
        return null;
    }

    @Override
    public void makeVisible() {
        pack();
        this.setVisible(true);
    }
}
