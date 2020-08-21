package Buttons;

import java.awt.event.*;

// prints random movie
public class RandomMovieListener extends ListenerClass implements ActionListener {

    public RandomMovieListener() {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        db.printRandomMovie();
    }
}