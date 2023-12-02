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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) map.put(inorder[i], i);
        
        return buildTreeHelper(0,n-1,0,n-1,preorder,map);
    }
    
    private TreeNode buildTreeHelper(int pl, int pr, int il, int ir, int[] preorder, HashMap<Integer,Integer> inorder){
        
        if(pl>pr || il>ir) return null;
        
        TreeNode node = new TreeNode(preorder[pl]);
        
        int plInorder = inorder.get(preorder[pl]);
        
        node.left = buildTreeHelper(pl+1, pl+plInorder-il, il, plInorder-1, preorder,inorder);
        node.right = buildTreeHelper(pl+plInorder-il+1, pr, plInorder+1, ir, preorder, inorder);
        
        return node;
    }
}