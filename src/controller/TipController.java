package controller;

import model.ITipModel;
import model.TipModelImpl;
import parsing.TipBuilder;
import parsing.TipFileReader;
import view.MainView;
import view.ViewImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TipController extends JFrame implements IController {

    private ITipModel model;

    private MainView view;

   /* private Timer timer;
    private int speed = 1;
    private int tick = 0;*/

    public TipController(ITipModel model, MainView view) {
        this.model = model;
        this.view = view;
        this.view.setPreferredSize(new Dimension(800,800));
        this.view.setButtonListeners(this);


    }

    public ITipModel getModel() {
        return model;
    }

    /**
     * Creates the timer that runs for the animation. On each tick, the panel is updated if the
     * animation has not finished yet. If loops are allowed, denoted by the allowLoops boolean flag,
     * once the animation reaches the end, it resets the tick to zero.
     *
     * @return a Timer
     */
    /*private Timer createTimer() {
        // Default delay is 33ms to have speed of about 30FPS
        return new Timer(33 / 1, e -> {
            view.updatePanel(toDraw);
            });
    }*/

    @Override
    public void startGUI() {
     /*   this.tick = 0;
        speed = 1;
        this.timer = this.createTimer();
        timer.setInitialDelay(0);*/

     view.makeVisible();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Save file":
                saveFile();
                break;
            case "Load file":
                loadFile();
                break;
        }
    }

    private void saveFile() {
        MainView t = null;
        String fileName;
        t = new ViewImpl();
        fileName = "save" + ".txt";
        try {
            PrintWriter writer = new PrintWriter(fileName);
            writer.write(t.createView());
            writer.close();
        } catch (FileNotFoundException f) {
            throw new IllegalArgumentException("File path not found");
        }
    }
    private void loadFile() {
        BufferedReader br;
        String filePathToLoad = view.getFilePathInput();
        TipBuilder<ITipModel> builder = new TipModelImpl.Builder();
        ITipModel newModel;

        try {
            if (filePathToLoad != null) {
                br = new BufferedReader(new FileReader(filePathToLoad));
                newModel = TipFileReader.parseFile(br, builder);
                this.model = newModel;
                startGUI();
            }
        } catch (FileNotFoundException e) {
            view.setErrorMessage("File path not found. Please re-enter file path");
        }
    }
}
