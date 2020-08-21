package Buttons;

import TextManipulation.PrinterToConsole;

import javax.swing.*;
import java.util.ArrayList;

// returns an arraylist of components
// order matters, there are 12 total and each group of 3 is a row
public class ComponentsList {

    public static ArrayList<JComponent> listOfComponents()
    {
        JComponent nameText = new LabelMaker().makeComponent("Movie Name:");
        JComponent nameField = new TextFieldMaker().makeComponent("");
        JComponent listMoviesText = new LabelMaker().makeComponent("List of Movies");
        ((JLabel) listMoviesText).setVerticalAlignment(JLabel.BOTTOM);

        JComponent idText = new LabelMaker().makeComponent("Movie Length:");
        JComponent idField = new TextFieldMaker().makeComponent("for emergencies only");
        JScrollPane scrollableArea = ScrollPane.makePane();

        JButton removeButton = new ButtonMaker().makeButton("Remove!",new MovieRemoveListener());
        JButton addButton = new ButtonMaker().makeButton("Add!",new MovieRecordListener((JTextField)nameField,(JTextField)idField));
        JLabel stuffToPrint = PrinterToConsole.printArea();

        JButton movieInfoButton = new ButtonMaker().makeButton("Movie Info", new MovieSiteListener());
        JButton clearDB = new ButtonMaker().makeButton("Remove All Movies", new MovieClearAllListener());
        JButton randomMovie = new ButtonMaker().makeButton("Random Movie",new MovieRandomListener());

        ArrayList<JComponent> components = new ArrayList();
        components.add(nameText);
        components.add(nameField);
        components.add(listMoviesText);
        components.add(idText);
        components.add(idField);
        components.add(scrollableArea);
        components.add(removeButton);
        components.add(addButton);
        components.add(stuffToPrint);
        components.add(movieInfoButton);
        components.add(clearDB);
        components.add(randomMovie);

        return components;
    }
}
