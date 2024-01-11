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
    int res;
    public int maxAncestorDiff(TreeNode root) {
        res = 0;
        helper(root,root.val,root.val);
        return res;
    }
    
    private void helper(TreeNode root, int min, int max){
        if(root==null) return;
        
        res = Math.max(res,Math.max(Math.abs(root.val-min), Math.abs(root.val-max)));
        
        min = Math.min(root.val,min);
        max = Math.max(root.val,max);
        
        helper(root.left,min,max);
        helper(root.right,min,max);
    }
}