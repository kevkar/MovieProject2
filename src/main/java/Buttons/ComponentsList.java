package Buttons;

import javax.swing.*;
import java.util.ArrayList;

public class ComponentsList {

    public static ArrayList<JComponent> listOfComponents()
    {
        JComponent nameText = new LabelMaker().makeComponent("Movie Name:");
        JComponent nameField = new TextFieldMaker().makeComponent("");
        JComponent idText = new LabelMaker().makeComponent("Movie Length:");
        JComponent idField = new TextFieldMaker().makeComponent("for emergencies only");
        JButton removeButton = new ButtonMaker().makeButton("Remove!",new MovieRemoveListener());
        JButton movieInfoButton = new ButtonMaker().makeButton("Movie Info", new MovieSiteListener());
        JButton clearDB = new ButtonMaker().makeButton("Remove All Movies", new MovieClearAllListener());
        JButton addButton = new ButtonMaker().makeButton("Add!",new MovieRecordListener((JTextField)nameField,(JTextField)idField));
        JComponent listMoviesText = new LabelMaker().makeComponent("List of Movies");
        ((JLabel) listMoviesText).setVerticalAlignment(JLabel.BOTTOM);
        JButton randomMovie = new ButtonMaker().makeButton("Random Movie",new RandomMovieListener());
        JLabel stuffToPrint = PrinterToConsole.printArea();
        JScrollPane scrollableArea = ScrollPane.makePane();
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
