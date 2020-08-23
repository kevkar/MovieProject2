package Testing;

import MovieStuff.MovieDB;

import java.io.IOException;


public class Test1  {

    public MovieDB testdb1 = new MovieDB("TestFile1");
    private  String fakeFilm = "fakefilmabcdefg";
    private  String fakeLength = "thisisafakelength";

    public Test1() {}

    public void addmoviestest() throws IOException {
        System.out.println("Adding three movies");
        if(testdb1.addMovieGUI("Titanic",fakeLength))
            System.out.println(testdb1.toString());
        else
            System.out.println("test to add movie failed");
        if(testdb1.addMovieGUI("Sherlock JR",fakeLength))
            System.out.println(testdb1.toString());
        else
            System.out.println("test to add movie failed");
        if(testdb1.addMovieGUI("Eternal Sunshine",fakeLength))
            System.out.println(testdb1.toString());
        else
            System.out.println("test to add movie failed");

        System.out.println("Three movies added");
    }

    public void clearAllTest() throws IOException {
        System.out.println("starting with no movies: ");
        testdb1.clearAll();
        System.out.println(testdb1);
        addmoviestest();
        System.out.println("clearing all movies");
        testdb1.clearAll();
        System.out.println(testdb1);
    }

    public void randomMovieTest() throws IOException {
        addmoviestest();
        System.out.println("printing random movie 5 times");
        for (int i = 0; i < 5; i++)
            System.out.println(testdb1.randomMovie());
    }

    public void removeMovieTest() throws IOException {
        addmoviestest();
        System.out.println("removing eternal sunshine");
        testdb1.removeMovie("Eternal Sunshine");
        System.out.println(testdb1);
        System.out.println("adding eternal sunshine");
        testdb1.addMovieGUI("Eternal Sunshine",fakeLength);
        System.out.println(testdb1);
        System.out.println("Adding eternal sunshine again");
        testdb1.addMovieGUI("eternal sunshine",fakeLength);
        System.out.println(testdb1);
    }
}


