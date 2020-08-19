package Buttons;

import java.awt.event.*;
import MovieStuff.MovieDB;

public class RandomMovieListener extends ListenerClass implements ActionListener {

    public RandomMovieListener() {
    }

    // shows random movie with GUI
    @Override
    public void actionPerformed(ActionEvent ae) {
        //MovieDB db = MovieRecordListener.getDB();
        db.printRandomMovie();
    }
}