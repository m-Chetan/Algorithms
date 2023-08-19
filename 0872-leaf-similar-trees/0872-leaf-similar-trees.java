/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> q = new LinkedList<>();
        getLeafNodes(root1,q);
        
        boolean res = checkLeaves(root2,q);
        if(q.size()>0) return false;
        return res;
    }
    
    private void getLeafNodes(TreeNode root, Queue<TreeNode> q){
        if(root.left==null && root.right==null){
            q.add(root);
            return;
        }
        
        if(root.left!=null) getLeafNodes(root.left,q);
        if(root.right!=null) getLeafNodes(root.right,q);
    }
    
    private boolean checkLeaves(TreeNode root, Queue<TreeNode> q){
        if(root.left==null && root.right==null){
            if(q.size()>0 && root.val==q.peek().val) {
                q.remove();
                return true;
            }
            return false;
        }
        
        if(root.left!=null) {
            boolean left = checkLeaves(root.left,q);
            if(left==false) return false;
        }
        
        if(root.right!=null) {
            boolean right = checkLeaves(root.right,q);
            if(right==false) return false;
        }
    
        return true;
    }
}