package Buttons;

import MovieStuff.*;

// base class for getting the database
public class ListenerClass {
    protected static MovieDB db = new MovieDB();

    public static MovieDB getDB() {
        return db;
    }
}
