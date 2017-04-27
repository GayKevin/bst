import java.util.ArrayList;

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
    private String rating;
    /**
     * Lenght in minutes
     */
    private int lenght;
    /**
     * Audience Rating
     */
    private int audienceRating;
    /**
     * Actors
     */
    private ArrayList<String> actors;

    /**
     * Constructor movie
     * @param title movie
     * @param releaseYear movie
     * @param rating movie
     * @param lenght movie
     * @param audienceRating movie
     * @param actors movie
     */
    public Movie(String title, int releaseYear, String rating, int lenght, String audienceRating, ArrayList<String> actors){

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
    public int getAudienceRating() {
        return audienceRating;
    }

    /**
     * Set the audience rating
     * @param audienceRating int
     */
    public void setAudienceRating(int audienceRating) {
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

    @Override
    public String toString() {
        return super.toString();
    }

    public int compareTo(Movie movie){

    }
}
