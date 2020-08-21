package Buttons;

import java.awt.event.*;

// opens google search of movie for special cases
public class MovieSiteListener implements ListenerInterface {

    public MovieSiteListener() { }

    @Override
    public void actionPerformed(ActionEvent ae) {
        db.googleMovie(MovieRecordListener.text());
    }
}