package Buttons;

import java.awt.event.*;

// prints random movie
public class RandomMovieListener implements ListenerInterface {

    public RandomMovieListener() {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        db.printRandomMovie();
    }
}