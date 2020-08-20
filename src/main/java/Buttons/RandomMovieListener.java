package Buttons;

import java.awt.event.*;

public class RandomMovieListener extends ListenerClass implements ActionListener {

    public RandomMovieListener() {
    }

    // shows random movie with GUI
    @Override
    public void actionPerformed(ActionEvent ae) {
        db.printRandomMovie();
    }
}