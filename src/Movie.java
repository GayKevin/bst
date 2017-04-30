import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Kevin Gay on 26/04/2017.
 */

/**
 * Movie Class
 */
public class Movie {
    /**
     * Title
     */
    private String title;
    /**
     * Release Year
     */
    private int releaseYear;
    /**
     * Rating age
     */
    private String rating = "Unknown";
    /**
     * Lenght in minutes
     */
    private int lenght;
    /**
     * Audience Rating
     */
    private double audienceRating;
    /**
     * Actors
     */
    private ArrayList<String> actors = new ArrayList<String>();

    /**
     * Constructor movie
     * @param str string
     */
    public Movie(String str){
        String[] split = str.split("/");

        this.title = split[0];
        this.releaseYear = Integer.parseInt(split[1]);
        this.rating = split[2];
        this.lenght = Integer.parseInt(split[3]);
        this.audienceRating = Double.parseDouble(split[4]);

        if (split.length > 5){
            Collections.addAll(this.actors, split[5].split(","));
        }
    }

    public Movie(){

    }

    /**
     * get Title
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the title
     * @param title string
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the release year
     * @return int
     */
    public int getReleaseYear() {
        return releaseYear;
    }

    /**
     * Set the release year
     * @param releaseYear int
     */
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    /**
     * Get the rating
     * @return String
     */
    public String getRating() {
        return rating;
    }

    /**
     * Set the rating
     * @param rating String
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * Get the lenght
     * @return int
     */
    public int getLenght() {
        return lenght;
    }

    /**
     * Set the lenght
     * @param lenght int
     */
    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    /**
     * Get the audiance rating
     * @return int
     */
    public Double getAudienceRating() {
        return audienceRating;
    }

    /**
     * Set the audience rating
     * @param audienceRating Double
     */
    public void setAudienceRating(Double audienceRating) {
        if (audienceRating > 0 && audienceRating <= 10)
            this.audienceRating = audienceRating;
    }

    /**
     * get the Actors
     * @return ArrayList<String>
     */
    public ArrayList<String> getActors() {
        return actors;
    }

    /**
     * Set the actors
     * @param actors
     */
    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }

    /**
     * To String
     * @return String
     */
    @Override
    public String toString() {
        int i = 0;
        String str = "";

        str += this.getTitle() + '/';
        str += String.valueOf(this.getReleaseYear()) + '/';
        str += this.getRating() + '/';
        str += String.valueOf(this.getLenght()) + '/';
        str += String.valueOf(this.getAudienceRating()) + '/';


        for (String actor : this.actors) {
            i++;
            str += actor;
            if (i != this.actors.size())
                str += ',';
        }

        str += '\n';

        return str;
    }

    public int compareTo(Movie movie){
        return this.getTitle().compareTo(movie.getTitle());
    }

    public int compareTo(String movie){
        return this.getTitle().compareTo(movie);
    }
}
