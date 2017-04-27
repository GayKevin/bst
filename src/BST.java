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
        private Word data;
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
        public Node( Word d ) {
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
    public void add( Word d ) {
        root = add( d, root );
    }

    /**
     * Add node BST
     * @param d Word
     * @param n Node
     * @return Node
     */
    private Node add( Word d, Node n ) {
        if( n == null ) {
            return new Node( d );
        } else {
            if( d.compareTo(n.data) < 0 ) {
                n.left = add( d, n.left );
            } else if (d.compareTo(n.data) == 0) {
                n.data.setNbr();
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
        if ( n.left != null ) {
            printBST( n.left );
        }
        //go down right tree
        System.out.print( n.data.toString() + ' ');
        if( n.right != null ) {
            printBST( n.right );
        }
    }

    /**
     * Remove Node
      * @param d Wors
     */
    public void remove( Word d ) {
        if ( root == null ) {
            System.out.println( "No items to remove" );
        } else {
            root = remove( d, root );
        }
    }

    /**
     * Remove node
     * @param d Word
     * @param n Node
     * @return Node
     */
    private Node remove( Word d, Node n ) {
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
     * Contains word
      * @param d Word
     * @return true or false
     */
    public boolean contains( Word d ) {
        if ( root == null ) {
            System.out.println( "No items to search" );
            return false;
        } else {
            return contains( d, root );
        }
    }

    /**
     * Contains word
     * @param d Word
     * @param n Node
     * @return true or false
     */
    private boolean contains( Word d, Node n ) {
        if ( d.compareTo(n.data) == 0 ) {
            System.out.println(n.data.toString());
            return true;
        }
        if ( d.compareTo(n.data) < 0 ) {
            if ( n.left == null ) {
                System.out.println( "Item Not Found" );
                return false;
            } else {
                return contains( d, n.left );
            }
        } else {
            if ( n.right == null ) {
                System.out.println( "Item Not Found" );
                return false;
            } else {
                return contains( d, n.right );
            }
        }
    }
}