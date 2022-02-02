import java.util.LinkedList;
import java.util.Queue;

// Class SearchTree stores and prints a binary search tree of
// objects of type E.  E must implement the Comparable<E>
// interface.

public class SearchTree<E extends Comparable<E>> {
    private SearchTreeNode<E> overallRoot; // root of overall tree

    // post: constructs an empty search tree
    public SearchTree() {
        overallRoot = new SearchTreeNode<E>(null, null, null);
    }

    // post: value added to tree so as to preserve binary search tree
    // Time: O(2^height) or n
    // Space: O(height)
    public void add(E value) {
        if (overallRoot.data == null) {
            overallRoot = new SearchTreeNode<E>(value, null, null);
            return;
        }
        overallRoot = add(overallRoot, value);
    }

    // post: value added to tree so as to preserve binary search tree
    // Space: O(height)
    // Time: O(height) or O(n)
    private SearchTreeNode<E> add(SearchTreeNode<E> root, E value) {
        if (root == null) {
            root = new SearchTreeNode<E>(value, null, null);
        } else if (value.compareTo(root.data) > 0) {
            root.right = add(root.right, value);
        } else {
            root.left = add(root.left, value);
        }
        // BST has no duplicates
        return root;
    }

    // post: returns true if tree contains value, returns false otherwise
    public boolean contains(E value) {
        // TO DO:
        return contains(overallRoot, value);
    }

    // post: returns true if given tree contains value, returns false otherwise

    // Time: O(height)
    // Space: O(height)
    private boolean contains(SearchTreeNode<E> root, E value) {
        if (root.data == null) {
            return false;
        }

        else if (root.data.equals(value)) {
            return true;
        } else if (value.compareTo(root.data) > 0) {
            return contains(root.right, value);
        }
        // less than
        else {
            return contains(root.left, value);
        }

    }

    // post: value removed from tree so as to preserve binary search tree
    // time: O(height)
    // space: O(height)
    public void remove(E value) {
        overallRoot = remove(overallRoot, value);
    }

    // post: value removed to tree so as to preserve binary search tree
    // time: O(height)
    // space: O(height)
    private SearchTreeNode<E> remove(SearchTreeNode<E> root, E value) {
        if (!contains(root, value)){
            return root;
        }
        
        if (value.compareTo(root.data) == 0) {
            
            // if only a leaf:
            if (root.left == null && root.left == null) {
                root = null;
            }

            // if only a right branch
            else if (root.left == null) {
                root = root.right;
            }

            // if only a left branch
            else if (root.right == null) {
                root = root.left;
            }

            // if both a left and right branch
            else {
                root.data = findSmallest(root.right); 
            }
            return root;
        }

        else if (value.compareTo(root.data) > 0) {
            return remove(root.right, value);
        }

        else {
            return remove(root.left, value);
        }

    }

    // post: return the smallest value in the binary search tree
    // Time: O(height)
    // Space: O(height)
    private E findSmallest(SearchTreeNode<E> root) {
        if (root.left == null) {
            return root.data;
        }
        return findSmallest(root.left);
    }

    // Time: O(height)
    // Space: O(height)
    private SearchTreeNode<E> removeSmallest(SearchTreeNode<E> root) {
        if (root.left == null) {
            root = null;
            return root;
        } else {
            return removeSmallest(root.left);
        }
    }

    // post: prints the data of the tree, one per line
    // time: O(branches)
    // space: O(branches)
    public void print() {
       printInorder(this.overallRoot);
    }

    // post: prints the data of the tree using an inorder traversal
    // time: O(branches)
    // space O(branches)
    private void printInorder(SearchTreeNode<E> root) {
        if (root == null) {return;}
        printInorder(root.left);
        System.out.println(root.data);
        printInorder(root.right);
        return;

    }

    private static class SearchTreeNode<E> {
        public E data; // data stored in this node
        public SearchTreeNode<E> left; // left subtree
        public SearchTreeNode<E> right; // right subtree

        // post: constructs a leaf node with given data
        public SearchTreeNode(E data) {
            this(data, null, null);
        }

        // post: constructs a node with the given data and links
        public SearchTreeNode(E data, SearchTreeNode<E> left, SearchTreeNode<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
