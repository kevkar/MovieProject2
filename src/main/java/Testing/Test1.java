package Testing;

import MovieStuff.Movie;
import MovieStuff.MovieDB;

import java.io.IOException;


public class Test1  {
    static MovieDB testdb1 = new MovieDB("TestFile1");

    public static void addmoviestest() throws IOException {
        if(testdb1.addMovieGUI("Eternal Sunshine","testnumber"))
            System.out.println(testdb1.toString());
        else
            System.out.println("test to add movie failed");
    }
}


