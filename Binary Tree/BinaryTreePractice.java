// Height
public int height() {
    return height(overallRoot);
}
private int height (IntTreeNode root) {
    if (root == null) {
        return 0;
    }
    
    // Step 1
    int leftHeight = height(root.left);
    int rightHeight = height(root.right);
    
    // Step 2
    int myHeight = Math.max(leftHeight, rightHeight) + 1;
    
    //Step 3
    return myHeight;
}


// Balanced Binary Tree
class Solution {
    public boolean isBalanced(TreeNode root) {
        
        if (root == null) return true;
        
        if ((Math.abs(height(root.left) - height(root.right)) <= 1) && isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }
        
        return false;
    }
    
    private int height(TreeNode node){
        if(node == null) return 0;
        return (Math.max(height(node.left),height(node.right))+1);
    }
}

	
// Lowest Common Ancestor
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
}


// Search in a Binary Tree
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return root;
        else if(root.val == val)
            return root;
        else if(val < root.val)
            return searchBST(root.left, val);
        else
            return searchBST(root.right, val);
    }
}
