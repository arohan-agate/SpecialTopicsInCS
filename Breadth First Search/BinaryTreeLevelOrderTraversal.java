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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resSet = new ArrayList<>();
        if(root == null){
            return resSet;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> res = new ArrayList<>();//store nodes from one level
            for(int i = 0;  i < size; i++){
                TreeNode cur = queue.poll();                
                res.add(cur.val);
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            resSet.add(res); // add the level to final solution
            
        }
        return resSet;
    }
}
