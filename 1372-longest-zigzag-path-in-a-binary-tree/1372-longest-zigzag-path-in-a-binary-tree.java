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
    int ans;
    public int longestZigZag(TreeNode root) {
        ans = 0;
        if(root.left!=null) helper(root.left,0,1);
        if(root.right!=null) helper(root.right,1,1);
        
        return ans;
    }
    //dir -> 0 or 1 0 means left 1 means right
    private void helper(TreeNode root,int dir, int path){
        ans = Math.max(ans,path);
        
        if(root.left!=null){
            helper(root.left,0,dir==0 ? 1: path+1); 
        }
        if(root.right!=null){
            helper(root.right,1,dir==1 ? 1: path+1);
        }
        
        
    }
}