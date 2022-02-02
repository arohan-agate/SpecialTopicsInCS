// Class SearchTree stores and prints a binary search tree of
// objects of type E.  E must implement the Comparable<E>
// interface.

public class SearchTree<E extends Comparable<E>> {
    private SearchTreeNode<E> overallRoot; // root of overall tree

    //Constructor
    public SearchTree() {
        overallRoot = null;
    }

    //Method for adding values to the binary search tree
    //Runtime is O(2^height of tree)
    //Space complexity is O(height of tree)
    public void add(E value) {
        overallRoot = add(overallRoot, value);
    }

    //Private helper method for adding values to the binary search tree
    //Runtime is O(2^height of tree)
    //Space complexity is O(height of tree)
    private SearchTreeNode<E> add(SearchTreeNode<E> root, E value) {
      if(root == null) {
          root = new SearchTreeNode<>(value);
          return root;
      } else if(root.data.compareTo(value) > 0){
          root.left = add(root.left, value);
      } else if(root.data.compareTo(value) < 0) {
          root.right = add(root.right, value);
      }
      return root;
    }

    //Method to see if a SearchTree contains a certain value
    //Runtime is O(2^height of tree)
    //Space complexity is O(height of tree)
    public boolean contains(E value) {
        return contains(overallRoot, value);
    }   

    //Private helper method for checking whether a tree contains a value
    //Runtime is O(2^height of tree)
    //Space complexity is O(height of tree)
    private boolean contains(SearchTreeNode<E> root, E value) {
        if(root == null) return false;
        if(root.data.equals(value)) return true;
        return contains(root.left, value) || contains(root.right, value);
    }
    
    //Method for removing a value from the SearchTree
    //Runtime is O(2^height of tree)
    //Space complexity is O(height of tree)
    public void remove(E value) {
        overallRoot = remove(overallRoot, value);
    }
    
    //Private helper method for removing a value in a tree
    //Runtime is O(2^height of tree)
    //Space complexity is O(height of tree)
    private SearchTreeNode<E> remove(SearchTreeNode<E> root, E value) {
        if(root == null) return null;
        else if(root.data.compareTo(value) > 0) root.left = remove(root.left, value);
        else if(root.data.compareTo(value) < 0) root.right = remove(root.right, value);
        else {
            if(root.right == null) return root.left;
            else if(root.left == null) return root.right;
            else {
                root.data = findSmallest(root.right);
                root.right = remove(root.right, root.data);
            }
        }
        return root;
    }
    
    //Finds the smallest value in a SearchTreeNode
    //Runtime is O(height of tree)
    //Space complexity is O(height of tree)
    private E findSmallest(SearchTreeNode<E> root) {
        //Because this is a binary search tree, the left subtree's values are always smaller than the right subtree's
        //Base case
        if (root == null || root.data == null){
            return null;
        }
        //If there is no left subtree, the minimum value has been found
        if (root.left == null || root.left.data == null){
            return root.data;
        }
        //If there is a left subtree, call the method again
        return findSmallest(root.left);
    }

    //In order traversal of the binary search tree
    //Runtime is O(2^height of tree)
    //Space complexity is O(height of tree)
    public void print() {
        printInorder(overallRoot);
    }

    //Private helper method for printing the inorder traversal of the tree
    //Runtime is O(2^height of tree)
    //Space complexity is O(height of tree)
    private void printInorder(SearchTreeNode<E> root) {
        if(root == null) return;
        printInorder(root.left);
        System.out.println(root.data.toString());
        printInorder(root.right);
    }

    //A compareTo method to compare two SearchTreeNodes, this method ended up being useless
    //Runtime is O(1)
    //Space complexity is O(1)
    private int compareTo(SearchTreeNode<E> value){
        int result = this.overallRoot.data.compareTo(value.data);
        return result;
    }
    //Private inner class
    private static class SearchTreeNode<E> {
        public E data;                   // data stored in this node
        public SearchTreeNode<E> left;   // left subtree
        public SearchTreeNode<E> right;  //  right subtree

        // post: constructs a leaf node with given data
        public SearchTreeNode(E data) {
            this(data, null, null);
        }

        // post: constructs a node with the given data and links
        public SearchTreeNode(E data, SearchTreeNode<E> left,
                              SearchTreeNode<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
