package Listeners;

import MovieStuff.MovieDB;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// static variable movie database comes from here
public interface ListenerInterface extends ActionListener {
    MovieDB db = new MovieDB();

    @Override
    void actionPerformed(ActionEvent ae);
}
