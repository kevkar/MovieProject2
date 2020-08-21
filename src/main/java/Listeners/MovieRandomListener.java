package Listeners;

import java.awt.event.*;

// prints random movie
public class MovieRandomListener implements ListenerInterface {

    public MovieRandomListener() {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        db.printRandomMovie();
    }
}