package Buttons;

import java.awt.event.*;
import MovieStuff.MovieDB;

public class MovieSiteListener extends ListenerClass implements ActionListener {

    public MovieSiteListener() { }

    // opens letterboxd site with GUI
    @Override
    public void actionPerformed(ActionEvent ae) {
        //MovieDB db = MovieRecordListener.getDB();
        String boxText = MovieRecordListener.nameField().getText();
        db.letterboxd(boxText);
    }
}