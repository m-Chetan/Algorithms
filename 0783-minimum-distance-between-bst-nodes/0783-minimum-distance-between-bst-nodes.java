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
    public int minDiffInBST(TreeNode root) {
        List<Integer> sortedList = new ArrayList<>();
        inorder(root,sortedList);
        int n = sortedList.size();
        int min = Integer.MAX_VALUE;
        
        for(int i=1;i<n;i++){
            min = Math.min(min,Math.abs(sortedList.get(i) - Math.abs(sortedList.get(i-1))));
        }
        
        return min;
    }
    
    private void inorder(TreeNode root, List<Integer> list){
        if(root == null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
}