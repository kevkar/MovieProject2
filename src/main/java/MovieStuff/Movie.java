package MovieStuff;

import TextManipulation.LengthParser;

public class Movie implements Comparable<Movie>{

    private String name;
    private int length;


    // two constructors, one for name and length and one for just name
    public Movie(String name) throws Exception{
        this.name = name;
        this.length = LengthParser.getLength(name);
    }

    public Movie(String name, int length)
    {
        this.name = name;
        this.length = length;
    }

    // two getters for name and length
    public String getName() {
        return this.name;
    }

    public int getLength() {
        return this.length;
    }

    // gets time in 1:31 format rather than 91 minutes format
    public String getRealTime() {
        String realTime = this.length / 60 + ":" + this.length % 60;
        StringBuilder sb = new StringBuilder(realTime);
        if (this.length % 60 == 0) {
            realTime = sb.append('0').toString();
        }
        if ((this.length % 60) < 10 && ((this.length % 60) > 1)) {
            realTime = sb.insert(2,'0').toString();
        }
        return realTime;
    }

    // prints out movie length + movie name
    @Override
    public String toString() {
        return this.getRealTime() + " " + this.getName();
    }

    // compares movies by length
    @Override
    public int compareTo(Movie movie) {
        Integer num1 = this.getLength();
        Integer num2 = movie.getLength();
        return num1.compareTo(num2);
    }
}