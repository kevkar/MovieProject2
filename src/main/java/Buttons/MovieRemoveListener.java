package Buttons;

import java.awt.event.*;
import java.io.IOException;

//removes a movie and then sorts list
public class MovieRemoveListener implements ListenerInterface  {

    public MovieRemoveListener() {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        db.removeMovie(MovieRecordListener.text());
    }

}