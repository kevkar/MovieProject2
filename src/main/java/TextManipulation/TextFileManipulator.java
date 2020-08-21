package TextManipulation;

import MovieStuff.Movie;
import MovieStuff.MovieDB;

import java.io.File;
import java.util.Scanner;

public class TextFileManipulator {

    public static void makeTextFile(MovieDB db) throws Exception {
        File file = new File("MovieTestFile");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {

            String nextLine = scanner.nextLine();
            int length = Integer.parseInt(nextLine.substring(0,nextLine.indexOf(" ")));
            String title = nextLine.substring(nextLine.indexOf(" ") + 1);

            db.addMovie(new Movie(title,length));
        }

        db.clearTextFile();

        db.appendMoviesToFile();
    }
}
