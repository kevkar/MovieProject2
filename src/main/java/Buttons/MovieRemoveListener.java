package Buttons;

import java.awt.event.*;
import java.io.IOException;

public class MovieRemoveListener extends ListenerClass implements ActionListener  {

    public MovieRemoveListener() {
    }

    // removes a movie with GUI
    // clears and sorts //
    @Override
    public void actionPerformed(ActionEvent ae) {
        db.removeMovie(MovieRecordListener.text());
        try {
            db.clearAndAddMovies();
            MovieListListener.setList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}