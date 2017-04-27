import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Kevin Gay on 26/04/2017.
 */
public class Main
{
    public static void main(String [] args){
        BST bst = new BST();
        Scanner sc = new Scanner(System.in);

        readerFile(bst);

        while (true){
            System.out.println("----- Menu -----");
            System.out.println("Exit : q");
            System.out.println("Print the list order by title : p");
            System.out.println("Remove a movie by title : r");
            System.out.println("Add a movie : a");
            System.out.print("Input: ");
            if (sc.hasNextLine()){
                switch (sc.nextLine()){
                    case "p":
                        bst.printBST();
                        break;
                    case "r":
                        remove(bst);
                        break;
                    case "q":
                        return;
                }
            }
        }
    }

    private static void remove(BST bst){
        Movie movie = new Movie();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the title: ");

        if (sc.hasNextLine()) {
            movie.setTitle(sc.nextLine());
            bst.remove(movie);
        }
    }

    private static void search(BST bst){
        Scanner sc = new Scanner(System.in);

        System.out.println("---- Search ----");
        System.out.println("Search by title : 1");
        System.out.println("Search by rating : 2");
        System.out.println("Search by decade : 3");
        System.out.println("Search by stars : 4");
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
}
