import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class BSY
 */
public class BST {

    /**
     * Node Class
     */
    private static class Node {
        /**
         * Data node
         */
        private Movie data;
        /**
         * Left node
         */
        private Node left;
        /**
         * Right node
         */
        private Node right;

        /**
         * Constructor node
         * @param d
         */
        public Node( Movie d ) {
            data = d;
            left = null;
            right = null;
        }
    }

    /**
     * Root Node
     */
    private Node root;

    /**
     * Constructor BST
     */
    public BST() {
        root = null;
    }

    /**
     * BST is empty
     * @return true if empty
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Add Node
     * @param d
     */
    public void add( Movie d ) {
        root = add( d, root );
    }

    /**
     * Add node BST
     * @param d Movie
     * @param n Node
     * @return Node
     */
    private Node add( Movie d, Node n ) {
        if( n == null ) {
            return new Node( d );
        } else {
            if( d.compareTo(n.data) < 0 ) {
                n.left = add( d, n.left );
            } else {
                n.right = add( d, n.right );
            }
            return n;
        }
    }

    /**
     * Print the tree
      */
    public void printBST() {
        if( isEmpty() ) {
            System.out.println("No items to print");
        } else {
            printBST( root );
        }
    }

    /**
     * Print the tree
     * @param n Node
     */
    private void printBST( Node n ) {
        //go down left tree
        if ( n.right != null ) {
            printBST( n.right );
        }
        //go down right tree
        System.out.print( n.data.toString() + ' ');
        if( n.left != null ) {
            printBST( n.left);
        }
    }

    /**
     * Remove Node
      * @param d Wors
     */
    public void remove( Movie d ) {
        if ( root == null ) {
            System.out.println( "No items to remove" );
        } else {
            root = remove( d, root );
        }
    }

    /**
     * Remove node
     * @param d Movie
     * @param n Node
     * @return Node
     */
    private Node remove( Movie d, Node n ) {
        if( n == null ) {
            return n;
        }
        //traverse to node & test number of children
        if( d.compareTo(n.data) < 0 ) {
            n.left = remove( d, n.left );
        } else if( d.compareTo(n.data) > 0 ) {
            n.right = remove( d, n.right );
        } else if( n.left != null && n.right != null ) {
            if( (int)( Math.random() * 2 ) == 0 ) {
                n.right = remove( n.data, n.right );
            } else {
                n.left = remove( n.data, n.left );
            }
        } else { //one child
            if( n.left != null ) {
                n = n.left;
            } else {
                n = n.right;
            }
        }
        return n;
    }

    /**
     * Contains Movie
      * @param d Movie
     * @return true or false
     */
    public Movie contains( Movie d ) {
        if ( root == null ) {
            System.out.println( "No items to search" );
            return null;
        } else {
            return contains( d, root );
        }
    }

    /**
     * Contains Movie
     * @param d Movie
     * @param n Node
     * @return true or false
     */
    private Movie contains( Movie d, Node n ) {
        if ( d.compareTo(n.data) == 0 ) {
            return n.data;
        }
        if ( d.compareTo(n.data) < 0 ) {
            if ( n.left == null ) {
                System.out.println( "Item Not Found" );
                return null;
            } else {
                return contains( d, n.left );
            }
        } else {
            if ( n.right == null ) {
                System.out.println( "Item Not Found" );
                return null;
            } else {
                return contains( d, n.right );
            }
        }
    }

    /**
     * Print the tree
     */
    public void writeBST() {
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            fw = new FileWriter("movies.txt");
            bw = new BufferedWriter(fw);

            if( isEmpty() ) {
                System.out.println("No items to write");
            } else {
                writeBST( root, bw );
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

    /**
     * Print the tree
     * @param n Node
     */
    private void writeBST( Node n, BufferedWriter bw ) throws IOException {
        //go down left tree
        if ( n.right != null ) {
            writeBST( n.right, bw );
        }
        //go down right tree
        writeBST(n.data, bw);
        if( n.left != null ) {
            writeBST( n.left, bw );
        }
    }

    private void writeBST(Movie movie, BufferedWriter bw) throws IOException {
        bw.write(movie.toString());
    }

    public ArrayList<Movie> search(String rating){
        ArrayList<Movie> list = new ArrayList<Movie>();

        if ( root == null ) {
            System.out.println( "No items to search" );
            return null;
        } else {
            return search( rating, root, list );
        }
    }

    private ArrayList<Movie> search(String rating, Node n, ArrayList<Movie> list){
        //go down left tree
        if ( n.right != null ) {
            search( rating, n.right , list);
        }
        if ( rating.equals(n.data.getRating())) {
            list.add(n.data);
        }
        //go down right tree
        if( n.left != null ) {
            search( rating, n.left , list);
        }
        return list;
    }

    public ArrayList<Movie> search(int releaseYear){
        ArrayList<Movie> list = new ArrayList<Movie>();

        if ( root == null ) {
            System.out.println( "No items to search" );
            return null;
        } else {
            return search( releaseYear, root, list );
        }
    }

    private ArrayList<Movie> search(int releaseYear, Node n, ArrayList<Movie> list){
        //go down left tree
        if ( n.right != null ) {
            search( releaseYear, n.right , list);
        }
        if ( releaseYear / 10 == n.data.getReleaseYear() / 10) {
            list.add(n.data);
        }
        //go down right tree
        if( n.left != null ) {
            search( releaseYear, n.left , list);
        }
        return list;
    }


    public ArrayList<Movie> search(double rating){
        ArrayList<Movie> list = new ArrayList<Movie>();

        if ( root == null ) {
            System.out.println( "No items to search" );
            return null;
        } else {
            return search( rating, root, list );
        }
    }

    private ArrayList<Movie> search(double rating, Node n, ArrayList<Movie> list){
        //go down left tree
        if ( n.right != null ) {
            search( rating, n.right , list);
        }
        if ( (int) rating == n.data.getAudienceRating().intValue()) {
            list.add(n.data);
        }
        //go down right tree
        if( n.left != null ) {
            search( rating, n.left , list);
        }
        return list;
    }
}