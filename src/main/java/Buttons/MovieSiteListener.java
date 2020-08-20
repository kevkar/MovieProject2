package Buttons;

import java.awt.event.*;

public class MovieSiteListener extends ListenerClass implements ActionListener {

    public MovieSiteListener() { }

    // opens google site with GUI
    @Override
    public void actionPerformed(ActionEvent ae) {
        db.googleMovie(MovieRecordListener.text());
    }
}