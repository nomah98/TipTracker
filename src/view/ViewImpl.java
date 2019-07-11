package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Set;

public class ViewImpl extends JFrame implements MainView {

    private JButton addShiftButton;
    private JButton addTipperButton;
    private JButton addJobButton;
    private JButton editShiftButton;
    private JButton removeShiftButton;
    private JButton saveButton;
    private JButton loadButton;

    private JPanel buttonPanel;
    private JPanel editorPanel;

    private JList<String> tippers;
    private JList<String> jobList;

    private DefaultListModel<String> tippersModel;
    private DefaultListModel<String> jobListModel;

    public ViewImpl() {
        super();

        this.setTitle("Shapes!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonPanel = new JPanel();


        JPanel shiftEditPanel = new JPanel();

        JPanel tipperEditPanel = new JPanel();

        JPanel jobListEditPanel = new JPanel();


        editorPanel = new JPanel();
        editorPanel.setLayout(new BoxLayout(editorPanel, BoxLayout.PAGE_AXIS));

        loadButton = new JButton("Load file");
        buttonPanel.add(loadButton);

        saveButton = new JButton("Save file");
        buttonPanel.add(saveButton);

        tippers = new JList<>();
        tippersModel = new DefaultListModel<>();

        jobList = new JList<>();
        jobListModel = new DefaultListModel<>();

        addShiftButton = new JButton("Add shift");
        shiftEditPanel.add(addShiftButton);

        editShiftButton = new JButton("Edit shift");
        shiftEditPanel.add(editShiftButton);

        removeShiftButton = new JButton("Remove shift");
        shiftEditPanel.add(removeShiftButton);

        addTipperButton = new JButton("Add tipper");
        tipperEditPanel.add(addTipperButton);

        addJobButton = new JButton("Add job");
        jobListEditPanel.add(addJobButton);

    }



    @Override
    public void setPreferredSize(Dimension d) {

    }

    @Override
    public void setButtonListeners(ActionListener listener) {
        addTipperButton.addActionListener(listener);
        addShiftButton.addActionListener(listener);
        addJobButton.addActionListener(listener);
        editShiftButton.addActionListener(listener);
        removeShiftButton.addActionListener(listener);
        saveButton.addActionListener(listener);
        loadButton.addActionListener(listener);
    }

    @Override
    public JList<String> getTippers() { return tippers; }

    @Override
    public DefaultListModel<String> getTippersModel() { return tippersModel; }
}
