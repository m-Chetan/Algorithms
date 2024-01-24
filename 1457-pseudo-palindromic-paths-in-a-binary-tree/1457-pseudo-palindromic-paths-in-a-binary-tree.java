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
    int[] freq;
    public int pseudoPalindromicPaths (TreeNode root) {
        freq  = new int[10];
        return helper(root);
    }
    
    private int helper(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            freq[root.val]++;
            int oddCount = 0;
            for(int i=0;i<=9;i++){
                if(freq[i]%2 != 0)  oddCount++;
            }
            freq[root.val]++;
            if(oddCount>1) return 0;
            return 1;
        }
        
        freq[root.val]++;
        
        int left = helper(root.left);
        int right = helper(root.right);
        freq[root.val]--;
        return left + right;
    }
}