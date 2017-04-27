import java.io.*;
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
                        addContact(bst);
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
        writeInFile(bst);
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
        Movie movie = new Movie();

        System.out.println("---- Search ----");
        System.out.println("Search by title : a");
        System.out.println("Search by rating : b");
        System.out.println("Search by decade : c");
        System.out.println("Search by stars : d");

        if (sc.hasNextLine()){
            switch (sc.nextLine()){
                case "a":
                    System.out.print("Enter the title :");
                    if (sc.hasNextLine())
                        movie.setTitle(sc.nextLine());
                        bst.contains(movie);
            }
        }
    }

    /**
     *  read in the file
     * @param bst is the tree
     */
    private static void readerFile(BST bst){
        File file = new File("movies.txt");

        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                bst.add(new Movie(sc.nextLine()));
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("We didnt find your file");
        }
    }

    private static void addContact(BST bst){
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
            System.out.print("Enter the audience rating 1-10 or a to skip: ");
            if (sc.hasNextDouble()){
                double audienceRating = sc.nextDouble();
                if (audienceRating > 0 && audienceRating <= 10){
                    movie.setAudienceRating(audienceRating);
                    isWorking = false;
                }
                sc.nextLine();
            }
            if (sc.hasNextLine())
                if (sc.nextLine().equals("a"))
                    isWorking = false;
            sc.nextLine();
        }

        bst.add(movie);
    }

    /**
     * Write in a file all the contact of the list
     */
    private static void writeInFile(BST bst){
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            fw = new FileWriter("addresses.txt");
            bw = new BufferedWriter(fw);

            for (int i = 0; i < size(); i++){
                String str = "";
                str += getNode(i).data.getFirstName() + ",";
                str += getNode(i).data.getLastName() + ",";
                str += getNode(i).data.getPhoneNumber() + ",";
                str += getNode(i).data.getAddress() + ",";
                str += getNode(i).data.getCity() + ",";
                str += getNode(i).data.getZipCode() + "\n";
                bw.write(str);
            }

            System.out.println("addresses.txt has been updated!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
