package MovieStuff;

import Buttons.*;
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
        public void addMovie(Movie movie) throws IOException {

            if (isMovieDuplicate(movie.getName())) {
                System.out.println("Movie " + '"' + movie.getName() + '"' + " already in database.");
            } else if (movie.getLength() > 400) {
                System.out.println("Why are you trying to watch a 6 hour movie c'mon.");
            } else if(movie.getLength() < 10) {
                System.out.println("That is not a real length");
            } else if (movie.getName().equals("")) {
                System.out.println("You forgot to enter a movie");
            } else {
                movieList.add(movie);
                System.out.println("Movie " + '"' + movie.getName() + '"' + " successfully added.");
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
            String text = MovieRecordListener.nameField().getText();

            if (text.isEmpty()) {
                System.out.println("That is not a movie.");
            } else {
                try {
                    //int length = Integer.parseInt(MovieRecordListener.IDField().getText());
                    Movie movie = new Movie(text);
                    addMovie(movie);
                } catch (Exception e) {
                    if (MovieRecordListener.IDField().getText().equals("")) {
                        System.out.println("Please enter length.");
                    } else {
                        System.out.println("Invalid Movie");
                    }
                }
            }
            sortMovies();
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

                    System.out.println("Movie " + '"' + title + '"' + " successfully removed.");
                    return true;
                }
            }
            System.out.println("Movie not found");
            return true;
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
                System.out.println("Movie database is empty!");
            } else {
                System.out.println("Random movie: " + randomMovie());
            }
        }

        // clears the entire movie list
        public void reset() {
            if (movieList.isEmpty()) {
                System.out.println("There are no movies what are you doing");
            } else {
                movieList.clear();
                System.out.println("Movie database successfully cleared.");
            }
        }

        //searches movie on letterboxd using GUI
       public void letterboxd(String name) {
          // String boxText = MovieRecordListener.nameField().getText();
           if (name.isEmpty()) {
               System.out.println("Try typing something first...");
           } else {
               try {
                   openMovieSite(name);
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }

    public void openMovieSite(String name) throws IOException {
        String link = "https://letterboxd.com/search/" ;
        link += name.replace(' ','+');
        java.awt.Desktop.getDesktop().browse(URI.create(link));
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

