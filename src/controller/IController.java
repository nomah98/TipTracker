package controller;

import java.awt.event.ActionListener;

public interface IController extends ActionListener {

    /**
     * This method starts the GUI. The user can then modify, add shifts, and gather other information from this window,
     * via buttons and other actions.
     */
    void startGUI();
}
