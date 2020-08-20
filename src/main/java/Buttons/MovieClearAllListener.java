package Buttons;

import java.awt.event.*;
import java.io.FileNotFoundException;

import MovieStuff.MovieDB;

public class MovieClearAllListener extends ListenerClass implements ActionListener {

    public MovieClearAllListener() {
    }

    // resets database with GUI
    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            db.reset();
            db.clearTextFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}