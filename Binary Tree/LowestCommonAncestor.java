/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        TreeNode ans = root;
        boolean toLeft = hasChild(root.left, p) && hasChild(root.left, q);
        boolean toRight = hasChild(root.right, p) && hasChild(root.right, q);
        
        if (toLeft == true) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (toRight == true) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
    
    private boolean hasChild(TreeNode node, TreeNode child) {
        if (node == null) return false;
        if (node.val == child.val) return true;
        boolean isLeftChild = hasChild(node.left, child);
        boolean isRightChild = hasChild(node.right, child);
        return isLeftChild || isRightChild;
    }
}
