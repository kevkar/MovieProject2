package Buttons;

import MovieStuff.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerClass {
    protected static MovieDB db = new MovieDB();

    public static MovieDB getDB() {
        return db;
    }
}
