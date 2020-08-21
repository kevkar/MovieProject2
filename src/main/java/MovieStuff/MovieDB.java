package MovieStuff;

import Buttons.*;
import TextManipulation.PrinterToConsole;

import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MovieDB {
    // holds movies in an array list
    private ArrayList<Movie> movieList = new ArrayList();

    public MovieDB() {};

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    // adds movies to the array list
    public void addMovie(Movie movie) {
        if (isMovieDuplicate(movie.getName())) {
            PrinterToConsole.printText("Movie " + '"' + movie.getName() + '"' + " already in database.");
        } else if (movie.getLength() > 400) {
            PrinterToConsole.printText("Why are you trying to watch a 6 hour movie c'mon.");
        } else if(movie.getLength() < 10) {
            PrinterToConsole.printText("That is not a real length");
        } else if (movie.getName().isEmpty()) {
            PrinterToConsole.printText("You forgot to enter a movie");
        } else {
            movieList.add(movie);
            PrinterToConsole.printText('"' + movie.getName() + '"' + " added with time " + movie.getRealTime());
        }
    }

    // checks for duplicate movie
    public boolean isMovieDuplicate(String title) {
        for (Movie movie : movieList) {
            if (title.toLowerCase().equals(movie.getName().toLowerCase()))
                return true;
        }
        return false;
    }

    //adds movies using the text fields for the GUI and sorts movies
    public void addMovieGUI() throws IOException {
        String text = MovieRecordListener.text();

        if (isMovieDuplicate(text)) {
            PrinterToConsole.printText("Movie already in database!");
            return;
        }

        if (text.isEmpty()) {
            PrinterToConsole.printText("Please enter a movie!");
        } else {
            try {
                Movie movie = new Movie(text);
                addMovie(movie);
            } catch (Exception e) {
                try {
                    int length = Integer.parseInt(MovieRecordListener.number());
                    Movie movie = new Movie(text, length);
                    addMovie(movie);
                } catch (NumberFormatException e2) {
                    PrinterToConsole.printText("Enter movie length as number 10-400");
                }
            }
        }
        sortMovies();
        MovieListListener.setList();
    }

        // prints out all movies in db
    @Override
    public String toString() {
        if (movieList.isEmpty()) {
            return "No movies to show.";
        }
        String theMovies = "";
        for (Movie movie: movieList) {
            theMovies += movie +"\n";
        }
        return theMovies;
    }

    // removes a movie from list with linear search
    public boolean removeMovie(String title) {
        for (Movie movie : movieList) {
            String movieName = movie.getName().toLowerCase();
            String searchedName = title.toLowerCase();
            if (movieName.equals(searchedName)) {
                movieList.remove(movie);
                PrinterToConsole.printText("Movie " + '"' + title + '"' + " removed.");
                try {
                    ListenerInterface.db.clearAndAddMovies();
                    MovieListListener.setList();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
            }
        }
        PrinterToConsole.printText("Movie not found");
        return false;
    }

    // sorts movies by length using comparable
    public boolean sortMovies() throws IOException {
        if (movieList.size() > 0) {
            Collections.sort(movieList);
            clearTextFile();
            appendMoviesToFile();
            return true;
        }
        return false;
    }

    // picks a random movie
    public Movie randomMovie() {
        Random random = new Random();
        int pick = random.nextInt(movieList.size());
        return movieList.get(pick);
    }

    // prints the random movie
    public void printRandomMovie() {
        if (getMovieList().isEmpty()) {
            PrinterToConsole.printText("Movie database is empty!");
        } else {
            PrinterToConsole.printText(randomMovie().toString());
        }
    }

    // clears the entire movie list
    public void reset() {
        if (movieList.isEmpty()) {
            PrinterToConsole.printText("There are no movies what are you doing");
        } else {
            movieList.clear();
            PrinterToConsole.printText("Movie database successfully cleared.");
        }
    }

    //searches movie on google using GUI
    public void googleMovie(String name) {
        if (name.isEmpty()) {
            PrinterToConsole.printText("Try typing something first...");
        } else {
            try {
                openMovieSite(name);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void openMovieSite(String name) throws IOException {
        String link = "https://www.google.com/search?q=" ;
        StringBuilder sb = new StringBuilder(link);
        sb.append(name.replace(' ','+'));
        sb.append("+length");
        java.awt.Desktop.getDesktop().browse(URI.create(sb.toString()));
    }

    public void appendMoviesToFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("MovieTestFile", true));
        for (Movie film : movieList)
            writer.append(film.getLength() + " " + film.getName() + "\n");

        writer.close();
    }

    public void clearTextFile() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("MovieTestFile");
        writer.print("");
        writer.close();
    }

    public void clearAndAddMovies() throws IOException {
        clearTextFile();
        appendMoviesToFile();
    }
}

