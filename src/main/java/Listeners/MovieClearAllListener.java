package Listeners;

import java.awt.event.*;
import java.io.FileNotFoundException;

// clears all movies in database
public class MovieClearAllListener implements ListenerInterface {

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            db.clearAll();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}