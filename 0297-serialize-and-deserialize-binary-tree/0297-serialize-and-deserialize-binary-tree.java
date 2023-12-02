/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        
        StringBuilder sb = new StringBuilder();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(q.size()>0){
            TreeNode node = q.remove();
            if(node == null) {
                sb.append("N ");
                continue;
            }
            else sb.append(node.val + " ");
            
            q.add(node.left);
            q.add(node.right);
                        
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        
        String[] stream = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(stream[0]));
        q.add(root);
        for(int i=1;i<stream.length;i++){
            TreeNode node = q.remove();
            
            if(!stream[i].equals("N")){
                TreeNode leftNode = new TreeNode(Integer.parseInt(stream[i]));
                node.left = leftNode;
                q.add(leftNode);
            }
            i++;
            if(!stream[i].equals("N")){
                TreeNode rightNode = new TreeNode(Integer.parseInt(stream[i]));
                node.right = rightNode;
                q.add(rightNode);
            }
            
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));