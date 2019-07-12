package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

public class ViewImpl extends JFrame implements MainView {

    private JButton addShiftButton;
    private JButton addTipperButton;
    private JButton addJobButton;
    private JButton editShiftButton;
    private JButton removeShiftButton;
    private JButton saveButton;
    private JButton loadButton;

    private JTextArea errorMessage;


    private JPanel buttonPanel;
    private JPanel shiftPanel;
    private JPanel jobPanel;
    private JPanel tipperPanel;

    private JList<String> shifts;
    private JList<String> tippers;
    private JList<String> jobList;

    private DefaultListModel<String> shiftsModel;
    private DefaultListModel<String> tippersModel;
    private DefaultListModel<String> jobListModel;

    private ArrayList<ShiftDisplay> shiftDisplays = new ArrayList<>();
    private SwingViewPanel tipTrackerPanel = new SwingViewPanel(shiftDisplays);

    public ViewImpl() {
        super();

        this.setTitle("TipTracker!!!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonPanel = new JPanel();
        getContentPane().add(buttonPanel, BorderLayout.NORTH);


        JPanel shiftEditPanel = new JPanel();

        JPanel tipperEditPanel = new JPanel();

        JPanel jobListEditPanel = new JPanel();


        shiftPanel = new JPanel();
        shiftPanel.setLayout(new BoxLayout(shiftPanel, BoxLayout.PAGE_AXIS));
        shiftPanel.setPreferredSize(new Dimension(400,400));

        /*jobPanel.add(new JScrollPane(jobList))
                .setPreferredSize(new Dimension(300, 500));*/

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

        buttonPanel.add(shiftEditPanel);
        buttonPanel.add(tipperEditPanel);


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

    @Override
    public String getFilePathInput() {
        JPanel inputPanel = new JPanel();

        JTextArea message = new JTextArea("Please enter file path to load:");
        inputPanel.add(message);
        JTextField filePath = new JTextField(20);
        inputPanel.add(filePath);
        int response = JOptionPane.showConfirmDialog(null, inputPanel,
                "Load file",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (response == JOptionPane.OK_OPTION) {
            return filePath.getText();
        } else {
            return null;
        }

    }

    @Override
    public void setErrorMessage(String s) {
        errorMessage.setText(s);
        buttonPanel.add(errorMessage);
        buttonPanel.revalidate();
        buttonPanel.repaint();
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
