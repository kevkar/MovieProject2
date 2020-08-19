package Buttons;

import java.awt.event.*;
import MovieStuff.MovieDB;

public class MovieListListener extends ListenerClass implements ActionListener {

    public MovieListListener() {
    }

    // prints the database with GUI
    @Override
    public void actionPerformed(ActionEvent ae) {
        //MovieDB db = MovieRecordListener.getDB();
        System.out.println(db);
    }
}