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
    public boolean isEvenOddTree(TreeNode root) {
        if(root.val %2 == 0) return false;
       
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);      
        
        int level = 0;
        
        while(q.size()>0){
            int size = q.size();
            
            for(int i=0;i<size;i++){
                TreeNode node = q.remove();
                
                if(level%2==0){
                    int next = (i==size-1) ? Integer.MAX_VALUE : q.peek().val;
                    
                    if(node.val%2 == 0 || node.val>=next) return false;
                }
                else{
                    int next = (i==size-1) ? Integer.MIN_VALUE : q.peek().val;
                    
                    if(node.val%2 == 1 || node.val<=next) return false;
                }
                
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            level++;
        }
        
        return true;
    }
}