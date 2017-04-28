import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Kevin Gay on 26/04/2017.
 */

/**
 * Main
 */
public class Main
{
    /**
     * Main
     * @param args
     */
    public static void main(String [] args){
        BST bst = new BST();
        Scanner sc = new Scanner(System.in);
        Boolean isWorking = true;

        readerFile(bst);

        while (isWorking){
            System.out.println("----- Menu -----");
            System.out.println("Exit : q");
            System.out.println("Print the list order by title : p");
            System.out.println("Remove a movie by title : r");
            System.out.println("Add a movie : a");
            System.out.println("Search : s");
            System.out.print("Input: ");
            if (sc.hasNextLine()){
                switch (sc.nextLine()){
                    case "p":
                        bst.printBST();
                        break;
                    case "a":
                        addMovie(bst);
                        break;
                    case "r":
                        remove(bst);
                    case "s":
                        search(bst);
                        break;
                    case "q":
                        isWorking = false;
                }
            }
        }
        bst.writeBST();
    }

    /**
     * Remove by title
     * @param bst tree
     */
    private static void remove(BST bst){
        Movie movie = new Movie();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the title: ");

        if (sc.hasNextLine()) {
            movie.setTitle(sc.nextLine());
            bst.remove(movie);
        }
    }

    /**
     * Search Menu
     * @param bst
     */
    private static void search(BST bst){
        Scanner sc = new Scanner(System.in);
        ArrayList<Movie> list = new ArrayList<Movie>();

        System.out.println("---- Search ----");
        System.out.println("Search by title : a");
        System.out.println("Search by rating : b");
        System.out.println("Search by decade : c");
        System.out.println("Search by stars : d");

        if (sc.hasNextLine()){
            Movie movie = new Movie();
            switch (sc.nextLine()){
                case "a":
                    System.out.print("Enter the title :");
                    if (sc.hasNextLine())
                        movie.setTitle(sc.nextLine());
                    movie = bst.contains(movie);
                    if (movie != null)
                        System.out.println(movie.toString());
                    break;
                case "b":
                    System.out.print("Enter the rating: ");
                    if (sc.hasNextLine())
                        list = bst.search(sc.nextLine());
                case "c":
                    System.out.print("Enter the year decade: ");
                    if (sc.hasNextInt())
                        list = bst.search(Integer.valueOf(sc.nextLine()));
                case "d":
                    System.out.print("Enter the audience rating: ");
                    if (sc.hasNextDouble())
                        list = bst.search(sc.nextDouble());
            }
            printList(list);
        }
    }

    private static void printList(ArrayList<Movie> list){
        if (list.isEmpty())
            return;

        for (Movie movie:
             list) {
            System.out.print(movie.toString());
        }
    }

    /**
     *  read in the file
     * @param bst is the tree
     */
    private static void readerFile(BST bst){
        File file = new File("movies.txt");
        ArrayList<String> list = new ArrayList<String>();

        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                list.add(sc.nextLine());
            }
            sc.close();
            Collections.shuffle(list, new Random(System.nanoTime()));

            for (String movie:
                 list) {
                bst.add(new Movie(movie));
            }

        }
        catch (FileNotFoundException e) {
            System.out.println("We didnt find your file");
        }
    }

    /**
     * Add movie
     * @param bst tree
     */
    private static void addMovie(BST bst){
        Movie movie = new Movie();
        Scanner sc = new Scanner(System.in);
        Boolean isWorking = true;
        String[] rating = new String[]{"G", "PG", "PG-13", "R", "NC-17"};

        System.out.println("---- Add new Movie -----");
        System.out.print("Enter the title: ");

        if (sc.hasNextLine())
            movie.setTitle(sc.nextLine());

        System.out.print("Enter the release year or a for empty: ");

        if(sc.hasNextInt())
            movie.setReleaseYear(sc.nextInt());
        sc.nextLine();

        System.out.println("Select the rating");
        System.out.println("G: a");
        System.out.println("PG: b");
        System.out.println("PG-13: c");
        System.out.println("R: d");
        System.out.println("NC-17: e");
        System.out.print("Enter the selection: ");
        if (sc.hasNextLine())
            switch (sc.nextLine()){
                case "a":
                    movie.setRating(rating[0]);
                    break;
                case "b":
                    movie.setRating(rating[1]);
                    break;
                case "c":
                    movie.setRating(rating[2]);
                    break;
                case "d":
                    movie.setRating(rating[3]);
                    break;
                case "e":
                    movie.setRating(rating[4]);
                    break;
            }

        System.out.print("Time of the movie : ");
        if (sc.hasNextInt())
            movie.setLenght(sc.nextInt());
        sc.nextLine();


        while (isWorking){
            System.out.print("Enter the audience rating 1-10: ");
            if (sc.hasNextDouble()){
                double audienceRating = sc.nextDouble();
                if (audienceRating > 0 && audienceRating <= 10){
                    movie.setAudienceRating(audienceRating);
                    isWorking = false;
                }
            }
            if (sc.nextLine().equals(""))
                isWorking = false;
        }

        isWorking = true;

        while(isWorking){
            System.out.print("Enter the name of the actor");
            if (sc.hasNextLine()){
                String str = sc.nextLine();
                if (str.equals(""))
                    isWorking = false;
                else
                    movie.getActors().add(str);
            }
        }

        bst.add(movie);
    }
}
