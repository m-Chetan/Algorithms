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
    public int goodNodes(TreeNode root) {
        return helper(root,Integer.MIN_VALUE);
    }
    
    private int helper(TreeNode root, int max){
        if(root==null) return 0;
        
        int count = 0;
        if(root.val>=max) count++;
        
        max = Math.max(max,root.val);
        int left = helper(root.left,max);
        int right = helper(root.right,max);
        
        return left+right+count;
    }
}