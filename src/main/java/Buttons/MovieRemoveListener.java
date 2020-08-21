package Buttons;

import java.awt.event.*;
import java.io.IOException;

//removes a movie and then sorts list
public class MovieRemoveListener extends ListenerClass implements ActionListener  {

    public MovieRemoveListener() {
    }

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