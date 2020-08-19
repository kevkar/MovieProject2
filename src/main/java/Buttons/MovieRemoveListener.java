package Buttons;

import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import MovieStuff.MovieDB;

import javax.xml.bind.Marshaller;


public class MovieRemoveListener extends ListenerClass implements ActionListener  {

    public MovieRemoveListener() {
    }

    // removes a movie with GUI
    // clears and sorts
    @Override
    public void actionPerformed(ActionEvent ae) {
        String title = MovieRecordListener.nameField().getText();
        db.removeMovie(title);
        try {
            db.clearAndAddMovies();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}