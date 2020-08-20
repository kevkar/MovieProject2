package MovieStuff;

import org.jsoup.*;
import org.jsoup.nodes.Document;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LengthParser {


    // finds movie length by googling movie and finding in html doc with Jsoup
    public static String example(String filmName) throws Exception
    {
        String newURL = googleURL(filmName);
        Document document = Jsoup.connect(newURL).get();

        Pattern pattern = Pattern.compile("[‧]\\s[0-9][0-9]?[h]?(&nbsp;)?\\s?[0-5]?[0-9]?(hour[s?])?[m]?(ins)?",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(document.toString());
        String length = "";

        /* three formats to march:
            1h 49m
            2 hours
            57 minutes
        */
        while (matcher.find())
        {
            length = matcher.group();
            if (length.contains("hour"))
                length = length.substring(2,3) + " " + length.substring(9);
            else if (length.contains("mins"))
                length = length.substring(2,4) + " " + length.substring(10);
            else
                length = matcher.group().substring(2);
        }
        return length;
    }

    // turns string into int
    public static int movieLengthInMins(String movieLengthString)
    {
        if (movieLengthString.contains("hours"))
        {
            int num = Integer.parseInt(movieLengthString.substring(0,1));
            return 60 * num;
        } else if (movieLengthString.contains("min"))
            return Integer.parseInt(movieLengthString.substring(0,2));
        else
        {
            int hours = Integer.parseInt(movieLengthString.substring(0,1));
            int mins = movieLengthString.length() == 6?
                    Integer.parseInt(movieLengthString.substring(3,5)) : Integer.parseInt(movieLengthString.substring(3,4));
            return 60 * hours + mins;
        }
    }

    // gets length of movie
    public static int getLength(String filmName) throws Exception {
        String filmLength = example(filmName);
        return movieLengthInMins(filmLength);
    }

    // assembles the URL search
    public static String googleURL(String filmName)
    {
        String google = "https://www.google.com/search?q=";
        StringBuilder sb = new StringBuilder(google);
        String searched = filmName;
        searched = searched.replace(" ","+");
        String filmLength = "+film+length";

        sb.append(searched);
        sb.append(filmLength);

        return sb.toString();
    }
}
