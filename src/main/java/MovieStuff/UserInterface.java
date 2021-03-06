package MovieStuff;

import Listeners.ListenerInterface;
import TextManipulation.TextFileManipulator;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;


public class UserInterface implements Runnable {

    private JFrame frame;

    public UserInterface() {    }

    //creates GUI with title, dimensions
    @Override
    public void run() {
        frame = new JFrame("Movie Time");
        frame.setPreferredSize(new Dimension(725, 450));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        try {
            createComponents(frame.getContentPane());
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame.pack();
        frame.setVisible(true);
    }

    //creates the grid and buttons
    private void createComponents(Container container) throws Exception {
        MovieDB db = ListenerInterface.db;

        TextFileManipulator.makeTextFile(db,db.getFileName());

        GridLayout layout = new GridLayout(4, 3);
        container.setLayout(layout);

        ArrayList<JComponent> components = ComponentsList.listOfComponents();

        for (JComponent component : components)
            container.add(component);
    }
}
