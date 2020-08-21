package Buttons;

import java.awt.event.*;
import java.io.FileNotFoundException;

// clears all movies in database
public class MovieClearAllListener implements ListenerInterface {

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            db.reset();
            db.clearTextFile();
            MovieListListener.setList();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}