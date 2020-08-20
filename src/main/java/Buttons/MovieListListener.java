package Buttons;

import java.awt.event.*;
import MovieStuff.MovieDB;

import javax.swing.*;

public class MovieListListener extends ListenerClass implements ActionListener {

    private static JTextArea label = new JTextArea(db.toString());

    // prints the database with GUI
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println(db);
        label.setText(db.toString());
    }

    public static JTextArea listenLabel()
    {
        return label;
    }
}