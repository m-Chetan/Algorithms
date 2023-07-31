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
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++) map.put(inorder[i],i);
        
        return constructTree(0,preorder.length-1,preorder,0,inorder.length-1,inorder,map);
    }
    
    private TreeNode constructTree(int preStart,int preEnd, int[] preorder, int inStart, int inEnd, int[] inorder, HashMap<Integer,Integer> map){
        
        if(preStart>preEnd || inStart>inEnd) return null;
        
        TreeNode node = new TreeNode(preorder[preStart]);
        
        int rootIdx = map.get(preorder[preStart]);
        
        node.left = constructTree(preStart+1,preStart+rootIdx-inStart,preorder,inStart,rootIdx-1,inorder,map);
        
        node.right = constructTree(preStart+rootIdx-inStart+1,preEnd,preorder,rootIdx+1,inEnd,inorder,map);
            
        return node;
        
    }
}