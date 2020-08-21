package Buttons;

import MovieStuff.MovieDB;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface ListenerInterface extends ActionListener {
    MovieDB db = new MovieDB();

    @Override
    void actionPerformed(ActionEvent ae);

}
