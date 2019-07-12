package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public interface MainView {
    /**
     * Sets preferred size of window to the given dimension.
     *
     * @param d the given dimesion.
     */
    void setPreferredSize(Dimension d);

    /**
     * Sets the button listeners of the given {@link IController}.
     *
     * @param listener the ActionListener to be added to the button
     */
    void setButtonListeners(ActionListener listener);

    JList<String> getTippers();

    DefaultListModel<String> getTippersModel();

    String getFilePathInput();

    void setErrorMessage(String message);

    String createView();

    void makeVisible();
}
