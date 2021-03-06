package Listeners;

import java.awt.event.*;
import java.io.IOException;

//removes a movie if movie in db then sorts list
public class MovieRemoveListener implements ListenerInterface  {

    public MovieRemoveListener() {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(db.removeMovie(MovieRecordListener.text())) {
            MovieListListener.setList();
        }
    }
}