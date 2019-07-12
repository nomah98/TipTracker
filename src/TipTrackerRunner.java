import controller.IController;
import controller.TipController;
import model.ITipModel;
import model.TipModelImpl;
import parsing.TipBuilder;
import parsing.TipFileReader;
import view.MainView;
import view.ViewImpl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TipTrackerRunner {

    public static void main(String[] args) {
        BufferedReader br;
        TipBuilder<ITipModel> builder = new TipModelImpl.Builder();
        ITipModel model = null;
        ViewImpl view = new ViewImpl() ;
        IController controller;

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-in") && i < args.length - 1) {
                try {
                    br = new BufferedReader(new FileReader(args[i + 1]));
                    model = TipFileReader.parseFile(br, builder);
                    i++;
                } catch (FileNotFoundException e) {
                    throw new IllegalArgumentException("Incorrect file path after \"-in\"");
                }
            }
        }
        if (model == null) {
            throw new IllegalArgumentException("Please enter a filepath for model");
        }

        controller = new TipController(model, view);
        controller.startGUI();
    }
}
